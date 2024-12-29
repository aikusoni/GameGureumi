package io.github.aikusoni.gamegureumi.spring.mvcstandard.model.view;

import io.github.aikusoni.gamegureumi.spring.core.config.MessageConfig;
import io.github.aikusoni.gamegureumi.spring.core.constants.ErrorCode;
import io.github.aikusoni.gamegureumi.spring.mvcstandard.config.LocaleConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

import static io.github.aikusoni.gamegureumi.spring.mvcstandard.constants.WebMvcTestMessageCode.WITH_MESSAGE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(controllers = GureumiResponseBodyTestController.class)
@Import({MessageConfig.class, LocaleConfig.class})
@ContextConfiguration(classes = {GureumiResponseBodyTestController.class})
public class GureumiResponseBodyTest {
    @Autowired
    private MockMvc mockMvc;

    @AfterAll
    public static void afterAllTests() {
        log.info("##### GureumiResponseBody 테스트가 완료되었습니다. #####");
    }

    @Test
    @DisplayName("메시지 없는 응답 테스트")
    void onlyOk() throws Exception {
        mockMvc.perform(
                        get("/ats-response-body/only-ok")
                                .accept("application/json")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("OK"));
    }

    @Test
    @DisplayName("메시지 있는 응답 테스트")
    void withMessageOk() throws Exception {
        mockMvc.perform(
                        get("/ats-response-body/with-message-ok")
                                .header("Accept-Language", Locale.getDefault().toLanguageTag())
                                .accept("application/json")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("OK"))
                .andExpect(jsonPath("$.message").value(WITH_MESSAGE.getMessage(Locale.getDefault())));
    }

    @Test
    @DisplayName("메시지 있는 에러 응답 테스트")
    void withMessageError() throws Exception {
        mockMvc.perform(
                        get("/ats-response-body/with-message-error")
                                .header("Accept-Language", Locale.getDefault().toLanguageTag())
                                .accept("application/json")
                )
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.INTERNAL_SERVER_ERROR.name()))
                .andExpect(jsonPath("$.message").value(WITH_MESSAGE.getMessage(Locale.getDefault())));
    }
}
