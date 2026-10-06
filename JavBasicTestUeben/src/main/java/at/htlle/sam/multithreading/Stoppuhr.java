package at.htlle.sam.multithreading;

public class Stoppuhr implements Runnable {
    @Override
    public void run() {
        int sek = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                sek++;
                System.out.println("Sekunde: " + sek);
            } catch (InterruptedException e) {
                System.out.println("Stoppuhr gestoppt bei " + sek + " Sekunden");
                return;
            }
        }
    }
}
