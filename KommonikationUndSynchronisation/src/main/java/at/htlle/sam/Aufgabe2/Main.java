package at.htlle.sam.Aufgabe2;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        PermitBox permitBox = new PermitBox();

        Thread[] threads =  new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Worker(permitBox), "Worker " + (i + 1));

            threads[i].start();
        }
        Thread.sleep(1000);

        for (int i = 0; i < threads.length; i++) {
            permitBox.releaseOne();
            Thread.sleep(700);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Alle Arbeiten abgeschlossen.");

    }
}
/*
## Aufgabe B – Einzelne Freigaben mit notify()

1. Ist bei mehreren Programmstarts immer derselbe Thread der nächste?
   Nein. Die Reihenfolge ist nicht garantiert und kann sich ändern.

2. Kann man vorhersagen, welcher wartende Thread von notify() ausgewählt wird?
   Nein. notify() wählt einen beliebigen wartenden Thread aus.
   Eine bestimmte Reihenfolge ist nicht garantiert.

3. Warum ist auch hier while notwendig?
   Nach dem Aufwachen muss die Bedingung erneut geprüft werden.
   Ein Thread kann auch ohne Benachrichtigung aufwachen
   (spurious wakeup), oder eine Freigabe wurde inzwischen von
   einem anderen Thread verbraucht.
*/
