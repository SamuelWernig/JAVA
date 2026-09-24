package at.htlle.sam.Aufgabe2;

public class Main {
    public static void main(String[] args) {
        Thread worker = new Thread(new Worker());
        worker.setName("Worker");
        worker.start();

        try {
            Thread.sleep(2000);
            System.out.println("main: sende interrupt");
            worker.interrupt();

            worker.join(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (worker.isAlive()) {
            System.out.println("main: Worker laeuft immer noch! Interrupt ging verloren.");
        } else {
            System.out.println("main: worker ist beendet");
        }
    }
}
