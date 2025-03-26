package at.htlle.sam.carcollection;

import java.util.Comparator;

public class SortDowntoUp implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        int nameVergleich = o1.getMarke().compareTo(o2.getMarke());
        if (nameVergleich != 0) {
            return nameVergleich;
        } else {
            return o1.getModell().compareTo(o2.getModell());
        }
    }
}
