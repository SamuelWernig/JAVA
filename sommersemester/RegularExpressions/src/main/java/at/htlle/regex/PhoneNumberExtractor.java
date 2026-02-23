package at.htlle.regex;

import java.util.regex.*;
import java.util.*;

public class PhoneNumberExtractor {

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("\\+\\d{1,3}(?:\\s\\d+)+");

    public static List<String> extractPhoneNumbers(String text) {
        List<String> numbers = new ArrayList<>();
        if (text == null) return numbers;

        Matcher matcher = PHONE_PATTERN.matcher(text);
        while (matcher.find()) {
            numbers.add(matcher.group());
        }
        return numbers;
    }
}
