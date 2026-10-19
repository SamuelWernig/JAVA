package at.htlle.sam.Aufgabe1;

public class Workstation {
    private boolean occupied = false;

    public synchronized void enter(String workerName) throws InterruptedException{
        while(occupied){
            wait();
        }
        occupied = true;
        System.out.println(workerName + " betritt den Prüfstand.");
    }

    public synchronized void leave(String workerName){
        occupied = false;

        notifyAll();
        System.out.println(workerName + " verlässt den Prüfstand.");
    }

}
