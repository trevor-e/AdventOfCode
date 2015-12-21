package com.trevore.advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by trevor on 12/10/15.
 */
public class Utils {

    public static String readToString(String filename) throws IOException {
        return readToList(filename).stream().collect(Collectors.joining("\n"));
    }

    public static List<String> readToList(String filename) throws IOException {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(filename);
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {
            return buffer.lines().collect(Collectors.toList());
        }
    }

    static int[] parseIntArray(String[] array) {
        return Stream.of(array).mapToInt(Integer::parseInt).toArray();
    }

}
