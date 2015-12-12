package com.trevore.advent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day3Test {

    private final Day3 day3;

    public Day3Test() {
        day3 = new Day3();
    }

    @Test
    public void testSolvePartOne() throws Exception {
        Assert.assertEquals(2592, day3.solvePartOne("Day3Input"));
    }
}