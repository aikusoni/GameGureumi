package io.github.aikusoni.gamegureumi.spring.core.utils;

import lombok.experimental.UtilityClass;

import java.time.*;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateTimeUtils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter OFFSET_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
    private static final DateTimeFormatter ZONE_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

    public static String formatDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DATE_FORMATTER);
    }

    public static LocalDate parseDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DATE_TIME_FORMATTER);
    }

    public static LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.trim().isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(dateTimeStr, DATE_TIME_FORMATTER);
    }

    public static String formatOffsetDateTime(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        return offsetDateTime.format(OFFSET_DATE_TIME_FORMATTER);
    }

    public static OffsetDateTime parseOffsetDateTime(String offsetDateTimeStr) {
        if (offsetDateTimeStr == null || offsetDateTimeStr.trim().isEmpty()) {
            return null;
        }
        return OffsetDateTime.parse(offsetDateTimeStr, OFFSET_DATE_TIME_FORMATTER);
    }

    public static String formatZonedDateTime(ZonedDateTime zonedDateTime) {
        if (zonedDateTime == null) {
            return null;
        }
        return zonedDateTime.format(ZONE_DATE_TIME_FORMATTER);
    }

    public static ZonedDateTime parseZonedDateTime(String zonedDateTimeStr) {
        if (zonedDateTimeStr == null || zonedDateTimeStr.trim().isEmpty()) {
            return null;
        }
        return ZonedDateTime.parse(zonedDateTimeStr, ZONE_DATE_TIME_FORMATTER);
    }

    public static String formatUnixTimeStamp(long unixTimeStamp, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(unixTimeStamp), zoneId).format(ZONE_DATE_TIME_FORMATTER);
    }
}
