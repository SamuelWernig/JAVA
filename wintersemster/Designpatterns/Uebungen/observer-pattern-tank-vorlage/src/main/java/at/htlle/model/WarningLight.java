package at.htlle.model;

import at.htlle.observer.Observer;

public class WarningLight implements Observer {
    @Override
    public void update(int fillLevel) {
        if (fillLevel < 15)
            System.out.println("[Warning] Not much tank left!");
        // TODO: Warnung bei niedrigem Füllstand
    }
}
