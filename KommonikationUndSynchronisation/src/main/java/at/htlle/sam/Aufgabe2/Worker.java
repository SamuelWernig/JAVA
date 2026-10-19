package at.htlle.sam.Aufgabe2;

public class Worker implements Runnable {

    private PermitBox permitBox;

    public Worker(PermitBox permitBox) {
        this.permitBox = permitBox;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        try {
            permitBox.acquire();
            System.out.println("Worker " + name + " arbeitet.");
            Thread.sleep(500);
            System.out.println("Worker " + name + " ist fertig.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Worker " + name + " wurde unterbrochen.");

        }
    }
}
