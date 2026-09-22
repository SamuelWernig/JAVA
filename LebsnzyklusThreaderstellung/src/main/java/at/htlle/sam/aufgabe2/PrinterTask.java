package at.htlle.sam.aufgabe2;

public class PrinterTask implements Runnable {
    @Override
    public void run() {

        for (int i=0;i<5;i++)
        {
            System.out.println("Printer: Zeile: "+ i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
