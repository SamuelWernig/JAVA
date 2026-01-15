package at.htlle.factory;

import at.htlle.formatter.MessageFormatter;
import at.htlle.formatter.PlainTextFormatter;
import at.htlle.notifier.Notifier;
import at.htlle.notifier.SmsNotifier;

public class SmsFactory implements NotificationFactory {

    @Override
    public Notifier createNotifier() {
        return new SmsNotifier();
    }

    @Override
    public MessageFormatter createFormatter() {
        return new PlainTextFormatter();
    }
}
