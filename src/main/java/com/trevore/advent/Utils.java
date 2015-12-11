package com.trevore.advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by trevor on 12/10/15.
 */
public class Utils {

    public static String readToString(InputStream input) throws IOException {
        return readToList(input).stream().collect(Collectors.joining("\n"));
    }

    public static List<String> readToList(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().collect(Collectors.toList());
        }
    }

}
