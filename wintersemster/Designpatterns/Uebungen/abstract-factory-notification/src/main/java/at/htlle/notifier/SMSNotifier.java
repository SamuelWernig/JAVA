package at.htlle.notifier;

public class SMSNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending message to " + recipient + ": " + message);
    }
}
