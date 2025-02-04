package com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observable;

import com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockPriceObservableImpl implements StockPriceObservable{

    private List<NotificationObserver> notificationObserverList = new ArrayList<>();
    @Override
    public void addObserver(NotificationObserver notificationObserver) {
        notificationObserverList.add(notificationObserver);
    }

    @Override
    public void deleteObserver(NotificationObserver notificationObserver) {
        notificationObserverList.remove(notificationObserver);
    }

    @Override
    public void notifyObserver() {
        for(NotificationObserver notificationObserver: notificationObserverList){
            notificationObserver.update();
        }
    }

    @Override
    public void updateMessage(String message) {
        System.out.println("message changed " + message);
        notifyObserver();
    }
}
