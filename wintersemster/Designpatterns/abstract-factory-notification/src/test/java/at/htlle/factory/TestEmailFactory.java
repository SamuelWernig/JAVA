package at.htlle.factory;

import at.htlle.formatter.MessageFormatter;
import at.htlle.notifier.EmailNotifier;
import at.htlle.notifier.Notifier;
import org.junit.*;

import static org.junit.Assert.*;

public class TestEmailFactory {

    @Test
    public void testCreateNotifierAndFormatter() {
        EmailFactory factory = new EmailFactory();
        Notifier notifier = factory.createNotifier();
        MessageFormatter formatter = factory.createFormatter();

        assertNotNull(notifier);
        assertNotNull(formatter);
        assertTrue(notifier instanceof EmailNotifier);
        assertTrue(formatter instanceof MessageFormatter);



    }


}
