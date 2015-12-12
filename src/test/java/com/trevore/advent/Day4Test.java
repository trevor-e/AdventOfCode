package com.trevore.advent;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day4Test {

    private final Day4 day4;

    public Day4Test() {
        day4 = new Day4();
    }

    @Test
    public void testSolvePartOne() throws Exception {
        Assert.assertEquals(117946, day4.solvePartOne("ckczppom"));
    }

    @Test
    public void testSolvePartTwo() throws Exception {
        Assert.assertEquals(3938038, day4.solvePartTwo("ckczppom"));
    }
}