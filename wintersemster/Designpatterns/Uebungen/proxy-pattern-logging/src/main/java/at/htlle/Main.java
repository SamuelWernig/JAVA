package at.htlle;

import at.htlle.proxy.LoggingProxy;
import at.htlle.service.RealService;
import at.htlle.service.Service;
// import at.htlle.service.RealService;
// import at.htlle.proxy.LoggingProxy;

public class Main {
    public static void main(String[] args) {
        // TODO: RealService und LoggingProxy instanziieren
        // TODO: Methode request() aufrufen
        RealService realService = new RealService();
        Service service = new LoggingProxy(realService); // durch Proxy ersetzen
        service.request();
    }
}
