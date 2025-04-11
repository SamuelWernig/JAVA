package at.htlle.sam.maven;

import com.google.common.collect.Lists;
import java.util.Comparator;

public class HelloGuava {
    public static void main(String[] args) {
        // Erstelle eine neue ArrayList mit Guava und `var`
        var list = Lists.newArrayList("Samuel", "Jonas", "Bob", "Michael");

        // Ausgabe der unsortierten Liste
        System.out.println("Unsortierte Liste:");
        System.out.println(list);
        System.out.println("----------------------------------------");

        // Liste sortieren
        list.sort(Comparator.naturalOrder());  // Sortiert die Liste in natürlicher Reihenfolge

        // Ausgabe der sortierten Liste
        System.out.println("Sortierte Liste:");
        System.out.println(list);

    }
}
