package at.htlle.sam.Aufgabe1;

public class Main {
    public static void main(String[] args) {
        Thread workerA = new Thread(new WorkerA());
        workerA.setName("WorkerA");
        workerA.start();

        Thread workerB = new Thread(new WorkerB());
        workerB.setName("WorkerB");
        workerB.start();

        try {
            Thread.sleep(2000);
            workerA.interrupt();
            workerB.interrupt();

            workerA.join();
            workerB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: worker ist beendet");
    }
}
