package io.github.aikusoni.gamegureumi.spring.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DateTimeUtilsTest {
    @Test
    @DisplayName("유닉스 타임 스탬프 변환 테스트")
    public void testUnixTimeStampToFormattedDateTimeString() {
        ZoneId zoneId = ZoneId.of("UTC");
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        long unixTimestamp = now.toInstant().getEpochSecond();
        String formatted = DateTimeUtils.formatUnixTimeStamp(unixTimestamp, zoneId);
        Assertions.assertEquals(formatted, DateTimeUtils.formatZonedDateTime(now));
    }


    @Test
    @DisplayName("유닉스 타임 스탬프 변환 테스트")
    public void test() {
        List<String> l = new ArrayList<>();
        l.add("a");
        for (int i = 0; i < l.size(); ++i) {
            System.out.println("Hello, world!");
            l.add(i+1, "x");
        }
    }
}
