package com.trevore.advent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by trevor on 12/10/15.
 */
public class Day2 {

    public int solvePartOne(String filename) throws IOException {
        return Utils.readToList(filename).stream()
                .map(line -> getWrappingPaperSquareFootage(line))
                .reduce(0, Integer::sum);
    }

    public int solvePartTwo(String filename) throws IOException {
        return Utils.readToList(filename).stream()
                .map(line -> getRibbonLength(line))
                .reduce(0, Integer::sum);
    }

    private int getWrappingPaperSquareFootage(String boxDimensions) {
        List<Integer> dimensions = getDimensionsAsList(boxDimensions);

        int length = dimensions.get(0);
        int width = dimensions.get(1);
        int height = dimensions.get(2);

        int side1 = length * width;
        int side2 = width * height;
        int side3 = height * length;

        int minSide = Arrays.stream(new int[]{side1, side2, side3})
                .min().getAsInt();

        return side1*2 + side2*2 + side3*2 + minSide;
    }

    private int getRibbonLength(String boxDimensions) {
        List<Integer> dimensions = getDimensionsAsList(boxDimensions);
        Collections.sort(dimensions);

        int wrappingRibbon = 2*dimensions.get(0) + 2*dimensions.get(1);
        int bowRibbon = dimensions.stream().reduce(1, (x, y) -> x * y);

        return wrappingRibbon + bowRibbon;
    }

    private List<Integer> getDimensionsAsList(String boxDimensions) {
        return Arrays.stream(boxDimensions.split("x"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
