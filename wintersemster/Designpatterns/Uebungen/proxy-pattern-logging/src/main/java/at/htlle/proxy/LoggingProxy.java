package at.htlle.proxy;

import at.htlle.service.Service;
import at.htlle.service.RealService;

public class LoggingProxy implements Service {
    private RealService realService;

    public LoggingProxy(RealService realService) {
        this.realService = realService;
    }

    @Override
    public void request() {
        System.out.println("[LOG] request in work");
        realService.request();
        // TODO: Logging hinzufügen
        // TODO: Weiterleitung an das echte Objekt
    }
}
