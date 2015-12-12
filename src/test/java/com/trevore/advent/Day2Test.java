package com.trevore.advent;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day2Test {

    private final Day2 day2;

    public Day2Test() {
        day2 = new Day2();
    }

    @Test
    public void testSolvePartOne() throws Exception {
        Assert.assertEquals(1606483, day2.solvePartOne("Day2Input"));
    }

    @Test
    public void testSolvePartTwo() throws Exception {
        Assert.assertEquals(3842356, day2.solvePartTwo("Day2Input"));
    }
}