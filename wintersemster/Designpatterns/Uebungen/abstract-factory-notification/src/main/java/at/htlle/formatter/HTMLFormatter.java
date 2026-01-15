package at.htlle.formatter;

import at.htlle.notifier.Notifier;

public class HTMLFormatter implements MessageFormatter {
    @Override
    public String format(String message) {
        return "<html><body>" + message + "</body></html>";
    }
}
