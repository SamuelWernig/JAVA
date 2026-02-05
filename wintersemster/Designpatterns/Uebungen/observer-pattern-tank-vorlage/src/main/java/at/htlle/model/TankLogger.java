package at.htlle.model;

import at.htlle.observer.Observer;

public class TankLogger implements Observer {
    @Override
    public void update(int fillLevel) {
        System.out.println("[Log] new fillLevel " +fillLevel + " %");
        // TODO: Logging implementieren
    }
}
