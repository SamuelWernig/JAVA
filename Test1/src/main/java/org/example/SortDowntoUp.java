package org.example;

import java.util.Comparator;

public class SortDowntoUp implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return (o1.getModell().compareTo(o2.getModell()))*(-1);
    }
}
