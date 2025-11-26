package at.htlle.proxy;

import at.htlle.service.Service;
import at.htlle.service.RealService;

public class LoggingProxy implements Service {
    private final RealService realService;


    public LoggingProxy(RealService realService) {
        this.realService = realService;
    }

    @Override
    public Object request() {
        System.out.println("[LOG] Zugriff auf Service");
        realService.request();
        return "[LOG] Zugriff auf Service";
    }
}
