package at.htlle.sam.multithreading;

public class MultithreadingMain {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Stoppuhr());
        Thread t2 = new Thread(new Zaehler());

        t1.start();
        t2.start();

        try {
            Thread.sleep(3500);

            t1.interrupt();
            t2.interrupt();

            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fertig");

        System.out.println("--------------------");
        Thread t3 = new Thread(t1, "ThreadName");
        System.out.println(t3.getName());
    }
}
