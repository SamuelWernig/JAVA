package at.htlle.service;

public class RealService implements Service {
    @Override
    public Object request() {
        System.out.println("Echte Anfrage wird verarbeitet.");
        return null;
    }
}
