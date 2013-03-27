package com.luna.console.Calculation;

import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleCalculationCoordinate {

    public void get(String inputValue) {

        Map<String, Integer> map = extractDataForMap(inputValue);
        int height = 0;
        int width = 0;
        for (Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (CoordinateUtils.LEFT.equals(entry.getKey())) {
                width -= value;
            } else if (CoordinateUtils.RIGHT.equals(entry.getKey())) {
                width += value;
            } else if (CoordinateUtils.UP.equals(entry.getKey())) {
                height += value;
            }
        }
        if (width < 0) {
            width = 0 - width;
        }
        System.out.print("width:" + width + "\t height:" + height);
    }

    private Map<String, Integer> extractDataForMap(String inputValue) {

        Map<String, Integer> map = newHashMap();
        List<String> input = CoordinateUtils.extractData(inputValue);
        String temp = "";
        for (String str : input) {
            if (str.matches("(\\D)")) {
                if (CoordinateUtils.LEFT.equals(str.toLowerCase())) {
                    temp = CoordinateUtils.LEFT;
                } else if (CoordinateUtils.RIGHT.equals(str.toLowerCase())) {
                    temp = CoordinateUtils.RIGHT;
                }
            } else {
                Integer data = Integer.parseInt(str);
                if (CoordinateUtils.LEFT.equals(temp)) {
                    Integer number = map.get(CoordinateUtils.LEFT);
                    if (number != null) {
                        number = number + data;
                    } else {
                        number = data;
                    }
                    map.put(CoordinateUtils.LEFT, number);
                } else if (CoordinateUtils.RIGHT.equals(temp)) {
                    Integer number = map.get(CoordinateUtils.RIGHT);
                    if (number != null) {
                        number = number + data;
                    } else {
                        number = data;
                    }
                    map.put(CoordinateUtils.RIGHT, number);
                } else if (temp.isEmpty()) {
                    map.put(CoordinateUtils.UP, data);
                }
            }
        }
        return map;
    }
}
