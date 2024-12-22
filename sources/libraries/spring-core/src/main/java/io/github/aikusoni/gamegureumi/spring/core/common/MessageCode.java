package io.github.aikusoni.gamegureumi.spring.core.common;

import java.util.Locale;

public final class MessageCode {
    private final String messageCode;

    private MessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return MessageUtils.m(messageCode);
    }

    public String getMessage(Object[] args) {
        return MessageUtils.m(messageCode, args);
    }

    public String getMessage(Object[] args, Locale locale) {
        return MessageUtils.m(messageCode, args, locale);
    }

    public String getMessage(Locale locale) {
        return MessageUtils.m(messageCode, null, locale);
    }

    public static MessageCode of(final String messageCode) {
        return new MessageCode(messageCode);
    }
}

