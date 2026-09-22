package at.htlle.sam.Aufgabe3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadScheduling {

    public static void worker(){

        System.out.println(Thread.currentThread().getName()+" Started");

        try {
            int time = ThreadLocalRandom.current().nextInt(100, 601);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" Finished");

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> worker());
        Thread t2 = new Thread(() -> worker());
        Thread t3 = new Thread(() -> worker());
        Thread t4 = new Thread(() -> worker());

        t1.setName("Worker-1");
        t2.setName("Worker-2");
        t3.setName("Worker-3");
        t4.setName("Worker-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }

}
