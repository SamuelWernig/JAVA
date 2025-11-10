package at.htlle.notifier;

import at.htlle.formatter.HtmlFormatter;

public class EmailNotifier implements Notifier {

    @Override
    public void send(String sender, String message) {
        HtmlFormatter formatter = new HtmlFormatter();
        System.out.println(sender + ": " + formatter.format(message));
    }
}
