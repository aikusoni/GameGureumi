package io.github.aikusoni.gamegureumi.spring.core.utils;

import io.github.aikusoni.gamegureumi.spring.core.config.MessageConfig;
import io.github.aikusoni.gamegureumi.spring.core.constants.CoreMessageCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MessageConfig.class)
public class MessageUtilsTests {

    @Autowired
    MessageSource messageSource;

    @Test
    public void testMessageInEnglish() {
        String message = CoreMessageCode.TEST.getMessage(Locale.ENGLISH);
        assertEquals("This is a test message of the core module.", message);
    }

    @Test
    public void testMessageInKorean() {
        String message = CoreMessageCode.TEST.getMessage(Locale.KOREAN);
        assertEquals("이 메시지는 코어 모듈의 메시지 테스트를 위한 메시지입니다.", message);
    }

    @Test
    public void testMessageWithDefault() {
        // 메시지가 없는 경우 기본 메시지 사용
        String message = CoreMessageCode.TEST_DEFAULT.getMessage(Locale.ENGLISH);
        assertEquals("This is a message to test if the default message is fetched correctly.", message);
    }
}
