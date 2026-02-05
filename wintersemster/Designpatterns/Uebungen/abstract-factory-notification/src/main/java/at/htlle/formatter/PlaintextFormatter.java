package at.htlle.formatter;

import at.htlle.notifier.Notifier;

public class PlainTextFormatter implements MessageFormatter{
    @Override
    public String format(String message) {
        return message.toUpperCase();
    }
}
