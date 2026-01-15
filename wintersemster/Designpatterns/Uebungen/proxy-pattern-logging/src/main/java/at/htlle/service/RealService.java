package at.htlle.service;

public class RealService implements Service {
    @Override
    public void request() {
        System.out.println("Echte Anfrage wird verarbeitet.");
    }
}
