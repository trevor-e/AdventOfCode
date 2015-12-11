package com.trevore.advent;

import java.io.IOException;

/**
 * Created by trevor on 12/10/15.
 */
public class AdventOfCodeRunner {

    public static void main(String[] args) throws IOException {
        Day1 day1 = new Day1();
        long solutionOne = day1.solvePartOne("Day1Input");
        int solutionTwo = day1.solvePartTwo("Day1Input");

        System.out.printf("Day1 Part 1: %d\n", solutionOne);
        System.out.printf("Day1 Part 2: %d\n", solutionTwo);
    }
}
