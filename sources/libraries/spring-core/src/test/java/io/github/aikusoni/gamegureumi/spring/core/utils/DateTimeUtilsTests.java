package io.github.aikusoni.gamegureumi.spring.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class DateTimeUtilsTests {
    @Test
    @DisplayName("유닉스 타임 스탬프 변환 테스트")
    public void testUnixTimeStampToFormattedDateTimeString() {
        ZoneId zoneId = ZoneId.of("UTC");
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        long unixTimestamp = now.toInstant().getEpochSecond();
        String formatted = DateTimeUtils.formatUnixTimeStamp(unixTimestamp, zoneId);
        Assertions.assertEquals(formatted, DateTimeUtils.formatZonedDateTime(now));
    }
}
