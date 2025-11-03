package at.htlle.streamapi;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        List<String> names = List.of("Anna", "Bernd", "Clara", "Daniel", "Eva");

        // Übung1
        System.out.println("=== Übung1: Klassische for-Schleife ===");
        for(String name : names) {
            System.out.println(name);
        }

        // Übung2
        System.out.println("\n=== Übung2: forEach auf der Collection ===");
        names.forEach(System.out::println);

        // Übung3
        System.out.println("\n=== Übung3: Stream.forEach ===");
        names.stream().forEach(System.out::println);

        // Übung4
        System.out.println("\n=== Übung4: Filter > 4 Zeichen (klassisch) ===");
        for (String name : names) {
            if (name.length() > 4) {
                System.out.println(name);
            }
        }

        // Übung5
        System.out.println("\n=== Übung5: Filter > 4 Zeichen (Stream) ===");
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
        filteredNames.forEach(System.out::println);

        // Übung6
        System.out.println("\n=== Übung6: Uppercase (klassisch mit gefilterter Liste) ===");
        for (String name : filteredNames) {
            System.out.println(name.toUpperCase());
        }

        // Übung7
        System.out.println("\n=== Übung7: Uppercase (Stream) ===");
        List<String> nameUpper = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        nameUpper.forEach(System.out::println);

        // Übung8
        System.out.println("\n=== Übung8: Gruppieren nach Länge (klassisch) ===");
        Map<Integer, List<String>> groupNames = new HashMap<>();
        for(String name: names){
            int len = name.length();
            groupNames.putIfAbsent(len,new ArrayList<>());
            groupNames.get(len).add(name);
        }
        System.out.println(groupNames);

        // Übung9
        System.out.println("\n=== Übung9: Gruppieren nach Länge (Stream) ===");
        Map<Integer, List<String>> map = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }
}
