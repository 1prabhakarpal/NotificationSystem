package com.notofication.api.utils;

import java.util.Calendar;

import org.springframework.util.ObjectUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class CommonUtils {

    private static final Calendar calendar = Calendar.getInstance();

    public static Long getCurrentTimeStamp() {
        return calendar.getTimeInMillis();
    }

    public static boolean isNotEmpty(final Object input) {
        return !ObjectUtils.isEmpty(input);
    }

    public static boolean isEmpty(final Object input) {
        return ObjectUtils.isEmpty(input);
    }

}
