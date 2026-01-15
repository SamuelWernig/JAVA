package at.htlle.test;

import at.htlle.model.TankSensor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TankSensorTest {

    @Test
    void testNotifyObservers() {
        TankSensor sensor = new TankSensor();

        CountingObserver observer1 = new CountingObserver();
        CountingObserver observer2 = new CountingObserver();

        sensor.addObserver(observer1);
        sensor.addObserver(observer2);

        sensor.setFillLevel(80);

        assertEquals(1, observer1.getCounter());
        assertEquals(1, observer2.getCounter());

        sensor.removeObserver(observer1);
        sensor.removeObserver(observer2);

        assertEquals(sensor.getFillLevel(), 80);
    }
}
