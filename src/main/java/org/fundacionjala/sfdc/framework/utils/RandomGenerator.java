package org.fundacionjala.sfdc.framework.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author alex.
 */
public class RandomGenerator {

    private static RandomGenerator instance;

    private String randomValue;

    private RandomGenerator() {
        SecureRandom random = new SecureRandom();
        int numBits = 12;
        int radix = 32;
        randomValue = new BigInteger(numBits, random).toString(radix);
    }

    public static RandomGenerator getInstance() {
        if (instance == null) {
            instance = new RandomGenerator();
        }
        return instance;
    }

    public String getRandomString() {
        return randomValue;
    }
}