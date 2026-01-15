package at.htlle.factory;

import at.htlle.formatter.MessageFormatter;
import at.htlle.formatter.PlaintextFormatter;
import at.htlle.notifier.Notifier;
import at.htlle.notifier.SMSNotifier;

public class SMSFactory implements NotificationFactory{
    @Override
    public Notifier createNotifier() {
        return new SMSNotifier();
    }

    @Override
    public MessageFormatter createFormatter() {
        return new PlaintextFormatter();
    }
}
