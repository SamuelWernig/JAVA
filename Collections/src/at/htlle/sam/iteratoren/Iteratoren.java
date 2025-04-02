package at.htlle.sam.iteratoren;

import java.util.*;

public class Iteratoren {
    public static void main(String[] args) {
        Set<String> field = new HashSet<String>();

        field.add("Samuel");
        field.add("Störenfried");
        field.add("John");
        field.add("Jane");

        for( String s : field) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------");

        Iterator<String> iter = field.iterator();

        while (iter.hasNext()) {
            String s = iter.next();
            System.out.println(s);
            if(s.equals("Störenfried")) {
                iter.remove();
            }
        }
        System.out.println(field.size());
        System.out.println("-------------------------------------");

        Map<Integer, String> sheep = new HashMap<Integer, String>();

        sheep.put(1, "Samuel");
        sheep.put(2, "Bob");
        sheep.put(3, "John");
        sheep.put(4, "Jane");
        sheep.put(5, "Störenfried");

        System.out.println(sheep);

        System.out.println(sheep.entrySet());

        Set<Integer> keys = sheep.keySet();
        System.out.println(keys);

    }
}
