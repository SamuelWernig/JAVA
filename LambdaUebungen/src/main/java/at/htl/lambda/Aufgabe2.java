
package at.htl.lambda;

import java.util.*;

public class Aufgabe2 {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>(List.of("Wien", "Berlin", "Zürich", "Amsterdam"));

        // TODO: Ersetzen Sie den anonymen Comparator durch einen Lambda-Ausdruck
        cities.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // TODO: Sortieren Sie die Liste zusätzlich nach der Länge der Städtenamen mit einem Lambda
        cities.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        System.out.println(cities);
    }
}
