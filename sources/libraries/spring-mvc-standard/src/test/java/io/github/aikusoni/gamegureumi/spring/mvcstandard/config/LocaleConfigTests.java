package io.github.aikusoni.gamegureumi.spring.mvcstandard.config;

import io.github.aikusoni.gamegureumi.spring.core.config.MessageConfig;
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

import static io.github.aikusoni.gamegureumi.spring.mvcstandard.constants.WebMvcTestMessageCode.LOCALE_CONFIG_TEST;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(controllers = LocaleConfigTestsController.class)
@Import({MessageConfig.class, LocaleConfig.class})
@ContextConfiguration(classes = {LocaleConfigTestsController.class})
public class LocaleConfigTests {
    @Autowired
    private MockMvc mockMvc;

    @AfterAll
    public static void afterAllTests() {
        log.info("##### 로케일 테스트가 완료되었습니다. #####");
    }

    @Test
    @DisplayName("입력 로케일에 맞게 응답 메시지가 반환되는지 테스트")
    void test() throws Exception {
        for (var locale : Locale.getAvailableLocales()) {
            mockMvc.perform(
                            get("/locale-config/test")
                                    .header("Accept-Language", locale.toLanguageTag())
                                    .accept("application/json")
                    )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.data").value("OK"))
                    .andExpect(jsonPath("$.message").value(LOCALE_CONFIG_TEST.getMessage(locale)));
        }
    }
}
