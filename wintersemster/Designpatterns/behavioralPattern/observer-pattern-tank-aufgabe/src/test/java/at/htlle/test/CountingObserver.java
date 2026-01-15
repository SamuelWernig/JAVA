package at.htlle.test;

import at.htlle.observer.Observer;

public class CountingObserver implements Observer {

    private int counter = 0;

    @Override
    public void update(int fillLevel) {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
