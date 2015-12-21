package com.trevore.advent;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day5Test {

    private final Day5 day5;

    public Day5Test() {
        day5 = new Day5();
    }

    @Test
    public void testSolvePartOne() throws Exception {
        Assert.assertEquals(255, day5.solvePartOne("Day5Input"));
    }

    @Test
    public void testSolvePartTwo() throws Exception {
        Assert.assertEquals(55, day5.solvePartTwo("Day5Input"));
    }
}