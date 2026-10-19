package at.htlle.sam.Aufgabe2;

public class PermitBox {
    private int permits = 0;

    public synchronized void acquire() throws InterruptedException {
        String name = Thread.currentThread().getName();

        while (permits == 0) {
            System.out.println(name + " wartet.");
            wait();
            System.out.println(name + " ist aufgewacht.");
        }

        permits--;
        System.out.println(name + " verwendet eine Freigabe.");
    }

    public synchronized void releaseOne() {
        permits++;
        System.out.println("Eine Freigabe wird erteilt.");
        notify();
    }
}