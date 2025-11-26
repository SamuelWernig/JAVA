package at.htlle.factory;

import at.htlle.formatter.HtmlFormatter;
import at.htlle.formatter.MessageFormatter;
import at.htlle.notifier.EmailNotifier;
import at.htlle.notifier.Notifier;

public class EmailFactory implements NotificationFactory {

    @Override
    public Notifier createNotifier() {
        return new EmailNotifier();
    }

    @Override
    public MessageFormatter createFormatter() {
        return new HtmlFormatter();
    }
}
