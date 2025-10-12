package at.htlle.logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoggerTest {

    @Test
    void testLoggerisSingelton() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        Assertions.assertTrue(logger1 == logger2);
    }


}
