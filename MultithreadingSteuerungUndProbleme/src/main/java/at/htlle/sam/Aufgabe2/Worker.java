package at.htlle.sam.Aufgabe2;

public class Worker implements Runnable {

    private long counter = 0;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            doWork();
            pause();
        }
        System.out.println("Worker beendet sich nach " + counter + " Durchlaeufen");
    }

    private void pause() {
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void doWork() {
        counter++;
        System.out.println("Arbeite... Durchlauf " + counter);
    }
}
