package com.trevore.advent;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by trevor on 12/20/15.
 */
public class Day6 {

    public long solvePartOne(String filename) throws IOException {
        List<Instruction> instructions = getInstructions(filename);

        int[][] coordinates = new int[1000][1000];

        for (Instruction instruction : instructions) {
            instruction.applyPartOne(coordinates);
        }

        return Arrays.stream(coordinates).flatMapToInt(x -> Arrays.stream(x))
                .filter(i -> {
                    return i == 1;
                })
                .count();
    }

    public long solvePartTwo(String filename) throws IOException {
        List<Instruction> instructions = getInstructions(filename);

        int[][] coordinates = new int[1000][1000];

        for (Instruction instruction : instructions) {
            instruction.applyPartTwo(coordinates);
        }

        return Arrays.stream(coordinates).flatMapToInt(x -> Arrays.stream(x))
                .reduce(0, Integer::sum);
    }

    private List<Instruction> getInstructions(String filename) throws IOException {
        return Utils.readToList(filename).stream()
                .map(Instruction::parse)
                .collect(Collectors.toList());
    }

    private static class Instruction {

        private final Command command;
        private final int[] startCoordinate;
        private final int[] endCoordinate;

        public Instruction(Command command, int[] startCoordinate, int[] endCoordinate) {
            this.command = command;
            this.startCoordinate = startCoordinate;
            this.endCoordinate = endCoordinate;
        }

        public void applyPartOne(int[][] coordinates) {
            for (int x = startCoordinate[0]; x <= endCoordinate[0]; x++) {
                for (int y = startCoordinate[1]; y <= endCoordinate[1]; y++) {
                    coordinates[x][y] = command.applyPartOne(coordinates[x][y]);
                }
            }
        }

        public void applyPartTwo(int[][] coordinates) {
            for (int x = startCoordinate[0]; x <= endCoordinate[0]; x++) {
                for (int y = startCoordinate[1]; y <= endCoordinate[1]; y++) {
                    coordinates[x][y] = command.applyPartTwo(coordinates[x][y]);
                }
            }
        }

        public static Instruction parse(String input) {
            Command command = Command.parse(input);

            input = input.substring(command.matcher.length());
            String[] firstSplit = input.split(" through ");

            int[] startCoordinate = Utils.parseIntArray(firstSplit[0].split(","));
            int[] endCoordinate = Utils.parseIntArray(firstSplit[1].split(","));

            return new Instruction(command, startCoordinate, endCoordinate);
        }
    }

    private enum Command {
        TurnOn("turn on ") {
            @Override
            public int applyPartOne(int oldValue) {
                return 1;
            }

            @Override
            public int applyPartTwo(int oldValue) {
                return oldValue + 1;
            }
        },

        TurnOff("turn off ") {
            @Override
            public int applyPartOne(int oldValue) {
                return 0;
            }

            @Override
            public int applyPartTwo(int oldValue) {
                return Math.max(0, oldValue-1);
            }
        },

        Toggle("toggle ") {
            @Override
            public int applyPartOne(int oldValue) {
                return oldValue == 0 ? 1 : 0;
            }

            @Override
            public int applyPartTwo(int oldValue) {
                return oldValue + 2;
            }
        };

        private final String matcher;

        Command(String matcher) {
            this.matcher = matcher;
        }

        public static Command parse(String input) {
            for (Command command : values()) {
                if (input.startsWith(command.matcher)) {
                    return command;
                }
            }

            throw new IllegalArgumentException("Unknown instruction " + input);
        }

        public abstract int applyPartOne(int oldValue);
        public abstract int applyPartTwo(int oldValue);
    }
}
