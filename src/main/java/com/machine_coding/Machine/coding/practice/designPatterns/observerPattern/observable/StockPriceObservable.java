package com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observable;

import com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public interface StockPriceObservable {
    
    List<NotificationObserver> notificationObserverList = new ArrayList<>();
    void addObserver(final NotificationObserver notificationObserver);
    void deleteObserver(final NotificationObserver notificationObserver);
    void notifyObserver();
    void updateMessage(final String message);

}
