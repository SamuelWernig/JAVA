package at.htlle.formatter;

public class PlainTextFormatter implements MessageFormatter {
    @Override
    public String format(String message) {
        return message.toUpperCase();
    }
}
