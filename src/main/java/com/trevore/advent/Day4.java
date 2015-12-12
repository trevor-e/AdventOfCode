package com.trevore.advent;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by trevor on 12/12/15.
 */
public class Day4 {

    public int solvePartOne(String secret) throws NoSuchAlgorithmException {
        return findCombinationWithPrefix(secret, "00000");
    }

    public int solvePartTwo(String secret) throws NoSuchAlgorithmException {
        return findCombinationWithPrefix(secret, "000000");
    }

    private int findCombinationWithPrefix(String secret, String prefix) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        for (int x = 1;; x++) {
            String combination = secret + Integer.toString(x);
            byte[] bytes = md.digest(combination.getBytes());

            String hexString = String.format("%02X%02X%02X ", bytes[0], bytes[1], bytes[2]);

            if (hexString.startsWith(prefix)) {
                return x;
            }
        }
    }
}
