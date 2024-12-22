package io.github.aikusoni.gamegureumi.spring.core.config;

import io.github.aikusoni.gamegureumi.spring.core.common.MessageUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MessageConfig {

    @Bean
    public MessageSource messageSource() throws IOException {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        // 동적으로 messages*.properties 파일을 찾기 위한 Resolver
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        List<String> baseNames = new ArrayList<>();

        // 모든 클래스패스 경로에서 core_messages.properties 파일 탐색
        Resource[] resources = resolver.getResources("classpath*:messages/*messages*.properties");

        // 각 메시지 파일을 MessageSource에 등록할 basename으로 변환
        for (Resource resource : resources) {
            String uri = resource.getURI().toString();
            String baseName = uri.substring(0, uri.lastIndexOf('.')).replace("file:", "").replaceFirst("^.*(?=messages/)", "");
            baseNames.add("classpath:" + baseName);
        }

        // 발견된 모든 messages 파일 경로를 MessageSource에 추가
        messageSource.setBasenames(baseNames.toArray(new String[0]));
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3600); // 캐시 시간 설정

        MessageUtils.setMessageSource(messageSource);

        return messageSource;
    }
}

