package at.htlle.sam.aufgabe2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PrinterTask printerTask = new PrinterTask();
        ComputeTask computeTask = new ComputeTask();

        Thread t1 = new Thread(printerTask, "Printer1");
        Thread t2 = new Thread(computeTask, "ComputeTask1");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Compute1 sum: " + computeTask.getSum());
        System.out.println("All Tasks finished");
    }
}
