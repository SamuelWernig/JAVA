package at.htlle.sam.multithreading;

public class Zaehler implements Runnable {
    @Override
    public void run() {
        long count = 0;
        while (!Thread.currentThread().isInterrupted()) {
            count++;
        }
        System.out.println("Zähler beendet bei: " + count);
    }
}
