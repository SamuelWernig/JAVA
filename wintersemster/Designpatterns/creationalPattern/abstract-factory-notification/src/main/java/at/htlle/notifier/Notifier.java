package at.htlle.notifier;

public interface Notifier {
    void send(String recipient, String message);
}
