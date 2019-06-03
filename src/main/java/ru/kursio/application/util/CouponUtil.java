package ru.kursio.application.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Random;

public final class CouponUtil {

    private static Logger log = LoggerFactory.getLogger(CouponUtil.class.getName());

    public static String generateRandomCoupon() {
        int defaultCodeLength = 12;
        char[] chars = "ABCDEFGHJKMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < defaultCodeLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}

