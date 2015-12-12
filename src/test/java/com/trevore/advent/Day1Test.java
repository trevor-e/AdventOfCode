package com.trevore.advent;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day1Test {

    private final Day1 day1;

    public Day1Test() {
        day1 = new Day1();
    }

    @Test
    public void testSolvePartOne() throws Exception {
        Assert.assertEquals(232, day1.solvePartOne("Day1Input"));
    }

    @Test
    public void testSolvePartTwo() throws Exception {
        Assert.assertEquals(1783, day1.solvePartTwo("Day1Input"));
    }
}