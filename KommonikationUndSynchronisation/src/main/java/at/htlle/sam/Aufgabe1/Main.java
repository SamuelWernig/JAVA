package at.htlle.sam.Aufgabe1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StartGate startGate = new StartGate();
        Workstation workstation = new Workstation();

        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            Worker worker = new Worker(startGate, workstation);
            threads[i] = new Thread(worker, "Techniker " + (i + 1));
            threads[i].start();
        }
        Thread.sleep(1000);

        System.out.println("Labor wird freigegeben");
        startGate.openGate();

        for (Thread thread : threads) {
            thread.join();
        }
    }


}
