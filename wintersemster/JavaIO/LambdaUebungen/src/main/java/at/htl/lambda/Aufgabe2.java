
package at.htl.lambda;

import java.util.*;

public class Aufgabe2 {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>(List.of("Wien", "Berlin", "Zürich", "Amsterdam"));

        // TODO: Ersetzen Sie den anonymen Comparator durch einen Lambda-Ausdruck
        cities.sort((a, b)-> a.compareTo(b));

        // TODO: Sortieren Sie die Liste zusätzlich nach der Länge der Städtenamen mit einem Lambda
        cities.sort((a, b)-> Integer.compare(a.length(), b.length()));

        System.out.println(cities);
    }
}
