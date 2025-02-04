package com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observer;

import com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observable.StockPriceObservable;

import java.util.Observable;

public interface NotificationObserver {
    void update();
}
