package at.htlle.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        List<String> names = List.of("Anna", "Bernd", "Clara", "Daniel", "Eva");

        // TODO: Gib alle Namen mit einer klassischen for-Schleife aus
        for (String name : names){
            System.out.println(name);
        }
        System.out.println();
        // TODO: Gib alle Namen mit forEach auf der Collection aus
        names.forEach(System.out::println);
        System.out.println();
        // TODO: Gib alle Namen mit Stream.forEach aus
        names.stream().forEach(System.out::println);
        System.out.println();
        // TODO: Filtere alle Namen mit mehr als 4 Zeichen (klassisch)
        for(String name : names){
            if(name.length()>4){
                System.out.println(name);
            }
        }
        System.out.println();
        // TODO: Filtere alle Namen mit mehr als 4 Zeichen (Stream)
        List<String> filterdNames = names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
        filterdNames.forEach(System.out::println);
        System.out.println();
        // TODO: Wandle alle Namen in Großbuchstaben um (klassisch)
        for(String name : names){
            System.out.println(name.toUpperCase());
        }
        System.out.println();
        // TODO: Wandle alle Namen in Großbuchstaben um (Stream)
        List<String> nameUpper = names.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        nameUpper.forEach(System.out::println);
        System.out.println();
        // TODO: Gruppiere die Namen nach Länge (klassisch)
        Map<Integer, List<String>> nameMap = new HashMap<>();
        for(String name : names){
            int len = name.length();
            nameMap.putIfAbsent(len, new ArrayList<>());
            nameMap.get(len).add(name);
        }
        for (Map.Entry<Integer, List<String>> entry : nameMap.entrySet()) {
            System.out.println("Länge " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        // TODO: Gruppiere die Namen nach Länge (Stream mit Collectors.groupingBy)
        Map<Integer, List<String>> nameMapStream = names.stream()
                .collect(Collectors.groupingBy(String::length));

        nameMap.forEach((length, nameList) ->
                System.out.println("Länge " + length + ": " + nameList));

    }
}
