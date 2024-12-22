package io.github.aikusoni.gamegureumi.spring.core.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public static String removeWhitespace(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\\s+", "");
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String truncate(String str, int maxLength) {
        if (str == null) {
            return null;
        }
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength);
    }

    public static String rpad(String str, int length, char padChar) {
        if (str == null) {
            return null;
        }
        if (str.length() >= length) {
            return str;
        }
        StringBuilder padded = new StringBuilder(str);
        while (padded.length() < length) {
            padded.append(padChar);
        }
        return padded.toString();
    }

    public static String lpad(String str, int length, char padChar) {
        if (str == null) {
            return null;
        }
        if (str.length() >= length) {
            return str;
        }
        StringBuilder padded = new StringBuilder();
        while (padded.length() + str.length() < length) {
            padded.append(padChar);
        }
        padded.append(str);
        return padded.toString();
    }
}

