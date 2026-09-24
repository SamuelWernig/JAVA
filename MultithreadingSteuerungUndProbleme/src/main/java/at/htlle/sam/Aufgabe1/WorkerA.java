package at.htlle.sam.Aufgabe1;

public class WorkerA implements Runnable {
    @Override
    public void run() {
        long counter = 0;
        while (!Thread.currentThread().isInterrupted()) {
            counter++;
        }
        System.out.println("Thread beendet sich bei " + counter);
    }
}
