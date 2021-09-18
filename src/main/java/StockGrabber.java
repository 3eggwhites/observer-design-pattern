package main.java;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements ISubject{

    private List<IObserver> observerList;

    private double ibmPrice;

    private double aaplPrice;

    private double googPrice;

    public StockGrabber() {
        observerList = new ArrayList<>();
    }

    @Override
    public void register(IObserver newObserver) {
        observerList.add(newObserver);
    }

    @Override
    public void unRegister(IObserver deleteObserver) {
        int observerIndex = observerList.indexOf(deleteObserver);
        System.out.println("Deleted observer " + (observerIndex+1));
        observerList.remove(observerIndex);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach((observer) -> {
            observer.update(ibmPrice, aaplPrice, googPrice);
        });
    }

    public void setIBMPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObservers();
    }

    public void setAAPLPrice(double aaplPrice) {
        this.aaplPrice = aaplPrice;
        notifyObservers();
    }

    public void setGOOGPrice(double googPrice) {
        this.googPrice = googPrice;
        notifyObservers();
    }
}
