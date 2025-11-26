package at.htlle.notifier;
import at.htlle.formatter.PlainTextFormatter;
public class SmsNotifier implements Notifier {


    public void send(String sender, String message) {
        PlainTextFormatter formatter = new PlainTextFormatter();
        System.out.println(sender + ": " + formatter.format((message)));
    }
}
