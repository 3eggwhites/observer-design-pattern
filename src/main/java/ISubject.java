package main.java;

public interface ISubject {

    void register(IObserver o);

    void unRegister(IObserver o);

    void notifyObservers();
}
