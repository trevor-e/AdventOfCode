package com.trevore.advent;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by trevor on 12/12/15.
 */
public class Day5 {

    public long solvePartOne(String filename) throws IOException {
        Pattern vowelsPattern = Pattern.compile("(.*[aeiou]){3,}");
        Pattern pairsPattern = Pattern.compile("(ab|cd|pq|xy)+");

        return Utils.readToList(filename).stream()
                .filter(s -> {
                    return vowelsPattern.matcher(s).find() && hasConsecutiveCharacters(s)
                            && !pairsPattern.matcher(s).find();
                })
                .count();
    }

    public long solvePartTwo(String filename) throws IOException {
        return Utils.readToList(filename).stream()
                .filter(s -> {
                    return hasTwoPairsWithoutOverlapping(s) && repeatsWithLetterInBetween(s);
                })
                .count();
    }

    private boolean hasConsecutiveCharacters(String input) {
        for (int x = 1; x < input.length(); x++) {
            if (input.charAt(x) == input.charAt(x-1)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasTwoPairsWithoutOverlapping(String input) {
        for (int x = 1; x < input.length(); x++) {
            char first = input.charAt(x-1);
            char second = input.charAt(x);

            for (int y = x+2; y < input.length(); y++) {
                char yFirst = input.charAt(y-1);
                char ySecond = input.charAt(y);

                if (first == yFirst && second == ySecond) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean repeatsWithLetterInBetween(String input) {
        for (int x = 2; x < input.length(); x++) {
            if (input.charAt(x) == input.charAt(x-2)) {
                return true;
            }
        }

        return false;
    }
}
