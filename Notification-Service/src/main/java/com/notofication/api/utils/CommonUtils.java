package com.notofication.api.utils;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.ObjectUtils;

import com.notofication.api.models.context.NotificationContextHolder;

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

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public static String getTenantId() {
        return NotificationContextHolder.getContext().tenantId();
    }

}
