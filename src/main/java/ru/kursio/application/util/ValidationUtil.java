package ru.kursio.application.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ValidationUtil {

    private static Logger log = LoggerFactory.getLogger(ValidationUtil.class.getName());

    public static boolean objectIsNotNull(Object obj) {
        return obj != null;
    }

    public static boolean stringIsNotEmpty(String str) {
        return !str.isEmpty();
    }
}

