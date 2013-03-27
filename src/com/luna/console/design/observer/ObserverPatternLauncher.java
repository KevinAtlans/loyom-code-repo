package com.luna.console.design.observer;

import com.luna.console.design.observer.observer.impl.CurrentConditionsDisplay;
import com.luna.console.design.observer.subject.impl.WeatherData;

public class ObserverPatternLauncher {

    /**
     * @param args
     */
    public static void main(String[] args) {

        WeatherData weather = new WeatherData();
        CurrentConditionsDisplay dis = new CurrentConditionsDisplay(weather);
        weather.setMeasurements(1.2f, 2.1f, 3.3f);
        dis.removeSelf();
        weather.setMeasurements(1.2f, 2.1f, 3.3f);
    }
}
