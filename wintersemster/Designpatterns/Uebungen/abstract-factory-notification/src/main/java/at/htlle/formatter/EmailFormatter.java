package at.htlle.formatter;

public class EmailFormatter implements MessageFormatter{
    @Override
    public String format(String message) {
        return "<html><body>" + message + "</body></html>";
    }
}
