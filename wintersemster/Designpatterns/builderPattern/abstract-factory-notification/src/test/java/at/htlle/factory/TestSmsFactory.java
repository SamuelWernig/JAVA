package at.htlle.factory;

import at.htlle.formatter.PlainTextFormatter;
import at.htlle.notifier.SmsNotifier;
import at.htlle.notifier.Notifier;
import at.htlle.formatter.MessageFormatter;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSmsFactory {

    @Test
    public void testSmsFactoryCreatesCorrectObjects() {
        SmsFactory factory = new SmsFactory();

        Notifier notifier = factory.createNotifier();
        MessageFormatter formatter = factory.createFormatter();

        assertNotNull(notifier);
        assertNotNull(formatter);
        assertTrue(notifier instanceof SmsNotifier);
        assertTrue(formatter instanceof PlainTextFormatter);
    }
}
