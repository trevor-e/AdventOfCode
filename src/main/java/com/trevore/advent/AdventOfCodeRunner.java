package com.trevore.advent;

import java.io.IOException;

/**
 * Created by trevor on 12/10/15.
 */
public class AdventOfCodeRunner {

    public static void main(String[] args) throws IOException {
//        Day2 day2 = new Day2();
//
//        int partOneSolution = day2.solvePartOne("Day2Input");
//        System.out.printf("Day2 Part1: %d\n", partOneSolution);
//
//        int partTwoSolution = day2.solvePartTwo("Day2Input");
//        System.out.printf("Day2 Part2: %d", partTwoSolution);
        Day3 day3 = new Day3();
        int partOneSolution = day3.solvePartOne("Day3Input");
        System.out.printf("Day3 Part1: %d\n", partOneSolution);
    }
}
