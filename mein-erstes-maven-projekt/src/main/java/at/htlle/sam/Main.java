package at.htlle.sam;

import com.google.common.collect.Lists;  // Importiere die Lists-Klasse

public class Main {
    public static void main(String[] args){
        // Erstelle eine neue ArrayList mit Guava
        var list = Lists.newArrayList();
        list.add("Samuel");
        list.add("Jonas");
        list.add("Bob");
        list.add("Michael");
        System.out.println(list);
    }
}
