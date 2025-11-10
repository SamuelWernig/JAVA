package at.htlle.formatter;

public class HtmlFormatter implements MessageFormatter {
    @Override
    public String format(String message) {
        return "<html><body>" + message + "</body></html>";
    }
}
