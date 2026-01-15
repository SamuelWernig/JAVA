package at.htlle.observer;

public interface Subject {
    public void notifyObservers();
    public void addObserver(Observer o);
    public void removeObserver(Observer o);

    // TODO: Methoden zur Verwaltung von Beobachtern deklarieren
}
