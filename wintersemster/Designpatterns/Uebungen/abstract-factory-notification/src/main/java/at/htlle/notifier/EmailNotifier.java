package at.htlle.notifier;

public class EmailNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("To: " + recipient + " : " + message);
    }
}
