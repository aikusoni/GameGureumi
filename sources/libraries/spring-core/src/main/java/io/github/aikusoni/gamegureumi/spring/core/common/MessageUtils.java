package io.github.aikusoni.gamegureumi.spring.core.common;

import lombok.Setter;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class MessageUtils {

    @Setter
    private static MessageSource messageSource;

    static String m(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, code, locale);
    }

    static String m(String code, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, code, locale);
    }

    static String m(String code, Object[] args, Locale locale) {
        return messageSource.getMessage(code, args, code, locale);
    }
}



