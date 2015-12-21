package com.trevore.advent;

import org.junit.Assert;
import org.junit.Test;

public class Day6Test {

    private final Day6 day6;

    public Day6Test() {
        day6 = new Day6();
    }

    @Test
    public void testSolvePartOne() throws Exception {
        Assert.assertEquals(377891, day6.solvePartOne("Day6Input"));
    }

    @Test
    public void testSolvePartTwo() throws Exception {
        Assert.assertEquals(14110788, day6.solvePartTwo("Day6Input"));
    }
}