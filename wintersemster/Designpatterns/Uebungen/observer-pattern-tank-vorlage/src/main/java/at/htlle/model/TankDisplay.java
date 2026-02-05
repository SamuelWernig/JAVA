package at.htlle.model;

import at.htlle.observer.Observer;

public class TankDisplay implements Observer {
    @Override
    public void update(int fillLevel) {
        System.out.println("Tankdisplay: " + fillLevel + " %");
        // TODO: Anzeige implementieren
    }
}
