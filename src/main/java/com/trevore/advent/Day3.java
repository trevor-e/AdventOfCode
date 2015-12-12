package com.trevore.advent;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by trevor on 12/11/15.
 */
public class Day3 {

    public int solvePartOne(String filename) throws IOException {
        Set<Coordinate> houses = new HashSet<>();

        Coordinate santaPosition = new Coordinate(0,0);
        houses.add(santaPosition);

        List<Movement> movements = Utils.readToString(filename).chars().boxed()
                .map(Movement::fromCharacter)
                .collect(Collectors.toList());

        for (Movement movement : movements) {
            Coordinate adjustment = movement.getAdjustment();
            santaPosition = new Coordinate(santaPosition.x + adjustment.x,
                    santaPosition.y + adjustment.y);
            houses.add(santaPosition);
        }

        return houses.size();
    }

    public int solvePartTwo(String filename) throws IOException {
        Set<Coordinate> houses = new HashSet<>();

        Coordinate santaPosition = new Coordinate(0,0);
        Coordinate robotPosition = new Coordinate(0,0);
        houses.add(santaPosition);
        houses.add(robotPosition);

        List<Movement> movements = Utils.readToString(filename).chars().boxed()
                .map(Movement::fromCharacter)
                .collect(Collectors.toList());

        for (int x = 0; x < movements.size(); x++) {
            Coordinate adjustment = movements.get(x).getAdjustment();

            if (x % 2 == 0) {
                santaPosition = new Coordinate(santaPosition.x + adjustment.x, santaPosition.y + adjustment.y);
                houses.add(santaPosition);
            } else {
                robotPosition = new Coordinate(robotPosition.x + adjustment.x, robotPosition.y + adjustment.y);
                houses.add(robotPosition);
            }
        }

        return houses.size();
    }

    private enum Movement {
        Left('<') {
            @Override
            public Coordinate getAdjustment() {
                return new Coordinate(-1, 0);
            }
        },

        Right('>') {
            @Override
            public Coordinate getAdjustment() {
                return new Coordinate(1, 0);
            }
        },
        Up('^') {
            @Override
            public Coordinate getAdjustment() {
                return new Coordinate(0, 1);
            }
        },

        Down('v') {
            @Override
            public Coordinate getAdjustment() {
                return new Coordinate(0, -1);
            }
        };

        private final char character;

        Movement(char character) {
            this.character = character;
        }

        public abstract Coordinate getAdjustment();

        public static Movement fromCharacter(int character) {
            for (Movement movement : values()) {
                if (movement.character == character) {
                    return movement;
                }
            }

            throw new IllegalArgumentException("Unknown character: " + character);
        }

    }
    
    private static class Coordinate {
        
        public final int x;
        public final int y;
        
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coordinate that = (Coordinate) o;

            if (x != that.x) return false;
            if (y != that.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
