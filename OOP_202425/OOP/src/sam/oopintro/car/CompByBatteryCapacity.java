package sam.oopintro.car;

import java.util.Comparator;

public class CompByBatteryCapacity implements Comparator<ECar> {
    @Override
    public int compare(ECar o1, ECar o2) {
        return Double.compare(o1.getBatteryCapacity(), o2.getBatteryCapacity());
    }
}
