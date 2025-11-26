package at.htlle.factory;

import at.htlle.notifier.Notifier;
import at.htlle.formatter.MessageFormatter;

public interface NotificationFactory {
    Notifier createNotifier();
    MessageFormatter createFormatter();
}
