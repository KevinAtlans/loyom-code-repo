package com.luna.console.design.observer.subject.impl;

import java.util.ArrayList;

import com.luna.console.design.observer.observer.Observer;
import com.luna.console.design.observer.subject.Subject;

public class WeatherData implements Subject {

    private final ArrayList<Observer> observers;

    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData() {

        observers = com.google.common.collect.Lists.newArrayList();
    }

    @Override
    public void registerObserver(Observer obs) {

        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {

        int index = observers.indexOf(obs);
        if (index >= 0)
            observers.remove(index);

    }

    @Override
    public void notifyObserver() {

        for (Observer obs : observers) {
            obs.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {

        notifyObserver();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {

        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }

    public float getTemperature() {

        return temperature;
    }

    public void setTemperature(float temperature) {

        this.temperature = temperature;
    }

    public float getHumidity() {

        return humidity;
    }

    public void setHumidity(float humidity) {

        this.humidity = humidity;
    }

    public float getPressure() {

        return pressure;
    }

    public void setPressure(float pressure) {

        this.pressure = pressure;
    }

}
