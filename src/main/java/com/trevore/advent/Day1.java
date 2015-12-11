package com.trevore.advent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by trevor on 12/10/15.
 */
public class Day1 {

    public long solvePartOne(String filename) throws IOException {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("Day1Input");
        String input = Utils.read(inputStream);

        long leftParenCount = input.chars().filter(c -> c == '(').count();
        long rightParenCount = input.chars().filter(c -> c == ')').count();

        return leftParenCount - rightParenCount;
    }

    public int solvePartTwo(String filename) throws IOException {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("Day1Input");
        String input = Utils.read(inputStream);

        int floorLevel = 0;
        char[] inputChars = input.toCharArray();
        for (int x = 0; x < inputChars.length; x++) {
            char command = inputChars[x];

            if (command == '(') {
                floorLevel++;
            } else if (command == ')') {
                floorLevel--;
            }

            if (floorLevel == -1) {
                return x + 1;
            }
        }

        return Integer.MAX_VALUE;
    }
}
