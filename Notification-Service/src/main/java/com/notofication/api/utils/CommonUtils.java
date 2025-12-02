package com.notofication.api.utils;

import org.springframework.util.ObjectUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class CommonUtils {

    public static boolean isNotEmpty(final Object input) {
        return !ObjectUtils.isEmpty(input);
    }
}
