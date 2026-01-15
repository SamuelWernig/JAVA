package at.htlle.formatter;

public class PlaintextFormatter implements MessageFormatter {
    @Override
    public String format(String message) {
        return message.toUpperCase();
    }
}
