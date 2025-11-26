package at.htlle.proxy;

import at.htlle.service.RealService;
import at.htlle.service.Service;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLoggingProxy {

    @Test
    public void testLoggingProxy() {
        Service service =  new LoggingProxy(new RealService());

        assertEquals("[LOG] Zugriff auf Service", service.request());

    }



}
