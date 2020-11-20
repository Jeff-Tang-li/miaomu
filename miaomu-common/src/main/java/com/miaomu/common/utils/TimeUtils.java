package com.miaomu.common.utils;

import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimeUtils {

    public static LocalDateTime toLocalDateTime(String num) {
        long l = Long.parseLong(num);
        return LocalDateTime.ofEpochSecond(l, 0, ZoneOffset.UTC);
    }

    public static String toSeconds(LocalDateTime localDateTime) {
        return StringUtils.isEmpty(localDateTime) ? "" : String.valueOf(localDateTime.toEpochSecond(ZoneOffset.UTC));
    }
}
