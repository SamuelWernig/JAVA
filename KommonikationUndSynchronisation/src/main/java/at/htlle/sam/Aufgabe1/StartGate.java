package at.htlle.sam.Aufgabe1;

class StartGate {
    private boolean open = false;
    public synchronized void waitForOpen() throws InterruptedException {
        while (!open) {
            wait();
        }
    }
    public synchronized void openGate() {
        open = true;
        notifyAll();
    }
}