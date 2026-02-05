package at.htlle.model;

import at.htlle.observer.Observer;
import at.htlle.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class TankSensor implements Subject {
    private List<Observer> observers = new ArrayList<>(); // TODO: initialisieren
    private int fillLevel;

    public void setFillLevel(int value) {
        this.fillLevel = value;
        notifyObservers();
        // TODO: notifyObservers aufrufen
    }

    public int getFillLevel() {
        return fillLevel;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(fillLevel);
        }
    }

    // TODO: Methoden von Subject implementieren

}
