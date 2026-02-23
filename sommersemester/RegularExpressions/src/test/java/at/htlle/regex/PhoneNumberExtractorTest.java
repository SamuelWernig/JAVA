package at.htlle.regex;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberExtractorTest {

    @Test
    void extractsSinglePhoneNumber() {
        String input = "Ruf mich an: +43 699 1234567!";
        List<String> result = PhoneNumberExtractor.extractPhoneNumbers(input);

        assertEquals(List.of("+43 699 1234567"), result);
    }

    @Test
    void extractsMultiplePhoneNumbers() {
        String input = "AT: +43 699 1234567, DE: +49 151 23456789, US: +1 202 555 0123";
        List<String> result = PhoneNumberExtractor.extractPhoneNumbers(input);

        assertEquals(
                List.of("+43 699 1234567", "+49 151 23456789", "+1 202 555 0123"),
                result
        );
    }

    @Test
    void returnsEmptyListWhenNoNumbersFound() {
        String input = "Keine Nummer hier.";
        assertEquals(List.of(), PhoneNumberExtractor.extractPhoneNumbers(input));
    }

    @Test
    void handlesNullInput() {
        assertEquals(List.of(), PhoneNumberExtractor.extractPhoneNumbers(null));
    }

    @Test
    void doesNotMatchWithoutPlus() {
        String input = "0699 1234567 ist lokal, aber ohne +.";
        assertEquals(List.of(), PhoneNumberExtractor.extractPhoneNumbers(input));
    }
}
