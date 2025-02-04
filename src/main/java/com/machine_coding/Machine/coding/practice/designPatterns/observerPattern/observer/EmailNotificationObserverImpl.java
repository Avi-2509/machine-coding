package com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observer;

import com.machine_coding.Machine.coding.practice.designPatterns.observerPattern.observable.StockPriceObservable;

public class EmailNotificationObserverImpl implements NotificationObserver{

    public String emailId;
    public StockPriceObservable stockPriceObservable;

    public EmailNotificationObserverImpl(StockPriceObservable stockPriceObservable, String emailId){
        this.emailId = emailId;
        this.stockPriceObservable = stockPriceObservable;
    }

    @Override
    public void update() {
        System.out.println(emailId + " message got for the update for email");
    }
}
