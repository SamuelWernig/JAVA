package at.htlle.observer;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    // TODO: Methoden zur Verwaltung von Beobachtern deklarieren
}
