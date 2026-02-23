package at.htlle.regex;

public class DateReplacer {

    public static String convertDateFormat(String text) {

        return text.replaceAll(
                "\\b(\\d{2})\\.(\\d{2})\\.(\\d{4})\\b",
                "$3-$2-$1"
        );
    }
}
