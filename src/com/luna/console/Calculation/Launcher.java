package com.luna.console.Calculation;

import java.text.DecimalFormat;
import java.util.List;

/**
 * 
 * @author xukai
 * 
 */
public class Launcher {

    /**
     * @param args
     */
    public static void main(String[] args) {

        DecimalFormat format = new DecimalFormat("#.##");

        String inputString = CoordinateUtils.getInputFromConsole();
        List<String> inputList = CoordinateUtils.extractData(inputString);

        int height = 0;
        int width = 0;

        String location = CoordinateUtils.UP;
        for (String str : inputList) {
            if (str.matches("(\\D)")) {
                location = CoordinateUtils.getCurrentDirection(location, str);
            } else {
                Integer data = Integer.parseInt(str);

                if (CoordinateUtils.UP.equals(location)) {
                    height += data;
                } else if (CoordinateUtils.DOWN.equals(location)) {
                    height -= data;
                } else if (CoordinateUtils.LEFT.equals(location)) {
                    width -= data;
                } else if (CoordinateUtils.RIGHT.equals(location)) {
                    width += data;
                }
            }
        }
        double hypotenuse = Math.sqrt(width * width + height * height);
        System.out.print("HYPOTENUSE:" + format.format(hypotenuse));
    }
}
