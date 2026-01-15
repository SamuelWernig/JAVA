package at.htlle.subsystem;

public class PrinterEngine {
    public void initialize() {
        System.out.println("Drucker wird initialisiert...");
    }

    public void print(String formattedText) {
        System.out.println("Drucke: " + formattedText);
    }
}
