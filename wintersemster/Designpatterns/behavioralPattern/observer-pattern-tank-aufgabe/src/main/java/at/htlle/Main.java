package at.htlle;

import at.htlle.model.*;

public class Main {
    public static void main(String[] args) {
        TankSensor sensor = new TankSensor();
        sensor.addObserver(new TankDisplay());
        sensor.addObserver(new TankLogger());
        sensor.addObserver(new WarningLight());
        sensor.setFillLevel(62);
        System.out.println();
        sensor.setFillLevel(12);
    }
}
