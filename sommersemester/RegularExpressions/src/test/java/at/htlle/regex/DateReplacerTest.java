package at.htlle.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateReplacerTest {

    @Test
    void convertsSingleDate() {
        String input = "Heute ist der 23.02.2026.";
        String expected = "Heute ist der 2026-02-23.";
        assertEquals(expected, DateReplacer.convertDateFormat(input));
    }

    @Test
    void convertsMultipleDates() {
        String input = "Start: 01.01.2020, Ende: 31.12.2020";
        String expected = "Start: 2020-01-01, Ende: 2020-12-31";
        assertEquals(expected, DateReplacer.convertDateFormat(input));
    }

    @Test
    void leavesTextWithoutDatesUnchanged() {
        String input = "Kein Datum vorhanden";
        assertEquals(input, DateReplacer.convertDateFormat(input));
    }

    @Test
    void doesNotConvertInvalidFormats() {
        String input = "Datum: 1.1.2020 oder 01-01-2020";
        assertEquals(input, DateReplacer.convertDateFormat(input));
    }
}
