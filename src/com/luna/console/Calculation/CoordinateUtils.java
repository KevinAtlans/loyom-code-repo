package com.luna.console.Calculation;

import static com.google.common.collect.Lists.newArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CoordinateUtils {

    public static final String LEFT = "l";

    public static final String RIGHT = "r";

    public static final String UP = "u";

    public static final String DOWN = "d";

    public static String getInputFromConsole() {

        String inputValue = null;
        try {
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your value:");
            inputValue = consoleInput.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputValue;
    }

    public static String getCurrentDirection(String location, String direction) {

        String currentDirection = null;

        location = location.toLowerCase();
        direction = direction.toLowerCase();
        if (CoordinateUtils.UP.equals(location)) {
            if (CoordinateUtils.LEFT.equals(direction)) {
                currentDirection = CoordinateUtils.LEFT;
            } else if (CoordinateUtils.RIGHT.equals(direction)) {
                currentDirection = CoordinateUtils.RIGHT;
            }
        } else if (CoordinateUtils.DOWN.equals(location)) {
            if (CoordinateUtils.LEFT.equals(direction)) {
                currentDirection = CoordinateUtils.RIGHT;
            } else if (CoordinateUtils.RIGHT.equals(direction)) {
                currentDirection = CoordinateUtils.LEFT;
            }
        } else if (CoordinateUtils.LEFT.equals(location)) {
            if (CoordinateUtils.LEFT.equals(direction)) {
                currentDirection = CoordinateUtils.DOWN;
            } else if (CoordinateUtils.RIGHT.equals(direction)) {
                currentDirection = CoordinateUtils.UP;
            }
        } else if (CoordinateUtils.RIGHT.equals(location)) {
            if (CoordinateUtils.LEFT.equals(direction)) {
                currentDirection = CoordinateUtils.UP;
            } else if (CoordinateUtils.RIGHT.equals(direction)) {
                currentDirection = CoordinateUtils.DOWN;
            }
        }
        return currentDirection;
    }

    public static List<String> extractData(String inputValue) {

        String firstChar = inputValue.substring(0, 1);
        boolean isNumber = firstChar.matches("(\\d)");

        String[] numberStr = inputValue.split("(\\D)");
        String[] directionStr = inputValue.split("(\\d)");

        List<String> numberList = getNewList(numberStr);
        List<String> letterList = getNewList(directionStr);

        int length = numberList.size() > letterList.size() ? numberList.size() : letterList.size();

        List<String> inputList = newArrayList();
        if (isNumber) {
            for (int i = 0; i < length; i++) {
                if (i < numberList.size()) {
                    String number = numberList.get(i);
                    if (number != null && !number.isEmpty()) {
                        inputList.add(number);
                    }
                }
                if (i < letterList.size()) {
                    String letter = letterList.get(i);
                    if (letter != null && !letter.isEmpty()) {
                        inputList.add(letter);
                    }
                }
            }

        } else {
            for (int i = 0; i < length; i++) {
                if (i < letterList.size()) {
                    String letter = letterList.get(i);
                    if (letter != null && !letter.isEmpty()) {
                        inputList.add(letter);
                    }
                }
                if (i < numberList.size()) {
                    String number = numberList.get(i);
                    if (number != null && !number.isEmpty()) {
                        inputList.add(number);
                    }
                }
            }
        }

        return inputList;
    }

    private static List<String> getNewList(String[] numberStr) {

        List<String> tempList = newArrayList();
        for (String str : numberStr) {
            if (!str.isEmpty()) {
                tempList.add(str);
            }
        }
        return tempList;
    }
}
