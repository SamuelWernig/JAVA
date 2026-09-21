package at.htlle.sam;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("Thread 'myThread' started...");
        Thread.sleep(500);
        System.out.println("Ending main().");
    }

}
