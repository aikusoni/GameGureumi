package io.github.aikusoni.gamegureumi.spring.mvcstandard.advice;

import io.github.aikusoni.gamegureumi.spring.core.config.MessageConfig;
import io.github.aikusoni.gamegureumi.spring.mvcstandard.config.LocaleConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

import static io.github.aikusoni.gamegureumi.spring.mvcstandard.constants.WebMvcMessageCode.*;
import static io.github.aikusoni.gamegureumi.spring.mvcstandard.constants.WebMvcTestMessageCode.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(controllers = CheckRoleTestsController.class)
@Import({AopAutoConfiguration.class, CheckRoleAdvice.class, RestExceptionHandler.class, MessageConfig.class, LocaleConfig.class})
@ContextConfiguration(classes = {CheckRoleTestsController.class})
public class CheckRoleTestsControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @AfterAll
    public static void afterAllTests() {
        log.info("##### 권한 테스트가 완료되었습니다. #####");
    }

    @Test
    @DisplayName("ADMIN 권한으로 ADMIN API 접근 테스트")
    void adminToAdmin() throws Exception {
        mockMvc.perform(
                        get("/check-role/admin")
                                .header("X-Roles", "ADMIN")
                                .header("Accept-Language", Locale.getDefault().toLanguageTag())
                                .accept("application/json")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("OK"))
                .andExpect(jsonPath("$.message").value(ADMIN_PERMISSION.getMessage()));
    }

    @Test
    @DisplayName("ADMIN 권한으로 USER API 접근 테스트")
    void adminToUser() throws Exception {
        mockMvc.perform(
                        get("/check-role/user")
                                .header("X-Roles", "ADMIN")
                                .header("Accept-Language", Locale.getDefault().toLanguageTag())
                                .accept("application/json")
                )
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.errorCode").value("FORBIDDEN"))
                .andExpect(jsonPath("$.errorAlias").value("RCA-000003"))
                .andExpect(jsonPath("$.message").value(NO_PERMISSION.getMessage()));
    }

    @Test
    @DisplayName("USER 권한으로 ADMIN API 접근 테스트")
    void userToAdmin() throws Exception {
        mockMvc.perform(
                        get("/check-role/admin")
                                .header("X-Roles", "USER")
                                .header("Accept-Language", Locale.getDefault().toLanguageTag())
                                .accept("application/json")
                )
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.errorCode").value("FORBIDDEN"))
                .andExpect(jsonPath("$.errorAlias").value("RCA-000003"))
                .andExpect(jsonPath("$.message").value(NO_PERMISSION.getMessage()));
    }

    @Test
    @DisplayName("USER 권한으로 USER API 접근 테스트")
    void userToUser() throws Exception {
        mockMvc.perform(
                        get("/check-role/user")
                                .header("X-Roles", "USER")
                                .header("Accept-Language", Locale.getDefault().toLanguageTag())
                                .accept("application/json")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("OK"))
                .andExpect(jsonPath("$.message").value(USER_PERMISSION.getMessage()));
    }

    @Test
    @DisplayName("권한이 설정되지 않은 계정으로 접근 테스트")
    void anonymous() throws Exception {
        mockMvc.perform(
                        get("/check-role/admin")
                                .header("Accept-Language", Locale.getDefault().toLanguageTag())
                                .accept("application/json")
                )
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.errorCode").value("FORBIDDEN"))
                .andExpect(jsonPath("$.errorAlias").value("RCA-000002"))
                .andExpect(jsonPath("$.message").value(NO_ROLES.getMessage()));
    }
}
