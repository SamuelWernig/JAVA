package at.htlle;

import at.htlle.proxy.LoggingProxy;
import at.htlle.service.RealService;
import at.htlle.service.Service;
// import at.htlle.service.RealService;
// import at.htlle.proxy.LoggingProxy;

public class Main {
    public static void main(String[] args) {
        Service service =  new LoggingProxy(new RealService());

        service.request();

    }
}
