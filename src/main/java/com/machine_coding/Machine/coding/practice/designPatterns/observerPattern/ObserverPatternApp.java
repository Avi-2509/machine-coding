package com.machine_coding.Machine.coding.practice.designPatterns.observerPattern;

import com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observable.IphoneStockPriceObservableImpl;
import com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observable.StockPriceObservable;
import com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observer.EmailNotificationObserverImpl;
import com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observer.NotificationObserver;

public class ObserverPatternApp {
    public static void main(String[] args) {
        StockPriceObservable stockPriceObservable = new IphoneStockPriceObservableImpl();

        NotificationObserver emailNotificationObserver1 = new
                EmailNotificationObserverImpl(stockPriceObservable, "avisrivastava@gmail.com");

        NotificationObserver emailNotificationObserver2 = new EmailNotificationObserverImpl(stockPriceObservable,
                "anujkesarwani@gmail.com");
        stockPriceObservable.addObserver(emailNotificationObserver1);
        stockPriceObservable.addObserver(emailNotificationObserver2);
        stockPriceObservable.updateMessage("hello");
    }
}
