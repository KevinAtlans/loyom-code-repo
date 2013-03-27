package com.luna.console.design.observer.observer.impl;

import com.luna.console.design.observer.observer.DisplayElement;
import com.luna.console.design.observer.observer.Observer;
import com.luna.console.design.observer.subject.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private final Subject weatherData;

    private float temperature;

    private float humidity;

    private float pressure;

    public CurrentConditionsDisplay(Subject weatherData) {

        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void removeSelf() {

        weatherData.removeObserver(this);
    }

    @Override
    public void display() {

        System.out.println(String.format("Temperature:%s \t Humidity:%s \t Pressure:%s",
                this.temperature, this.humidity, this.pressure));
    }

    @Override
    public void update(float temp, float humidity, float pressure) {

        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;

        display();
    }

}
