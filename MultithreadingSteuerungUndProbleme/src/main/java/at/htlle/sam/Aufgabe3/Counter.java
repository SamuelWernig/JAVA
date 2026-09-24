package at.htlle.sam.Aufgabe3;

public class Counter {
    private int value;

    public synchronized void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
