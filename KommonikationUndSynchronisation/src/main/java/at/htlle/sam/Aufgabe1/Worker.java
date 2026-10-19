package at.htlle.sam.Aufgabe1;

public class Worker implements Runnable {
    private final StartGate startGate;
    private final Workstation workstation;

    public Worker(StartGate startGate, Workstation workstation) {
        this.startGate = startGate;
        this.workstation = workstation;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        try {
            System.out.println(name + " wartet auf die Laborfreigabe.");
            startGate.waitForOpen();

            for (int i = 1; i <= 2; i++) {
                System.out.println(name + " möchte zum Prüfstand. Durchgang " + i);
                workstation.enter(name);

                try {
                    Thread.sleep(500);
                } finally {
                    workstation.leave(name);
                }
            }
            System.out.println(name + " ist fertig.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " wurde unterbrochen.");
        }
    }
}