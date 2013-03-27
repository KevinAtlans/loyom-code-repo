package com.luna.console.design.observer.subject;

import com.luna.console.design.observer.observer.Observer;

public interface Subject {

    public void registerObserver(Observer obs);

    public void removeObserver(Observer obs);

    public void notifyObserver();
}
