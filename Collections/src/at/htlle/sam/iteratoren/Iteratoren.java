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
        System.out.println("-------------------------------------");

        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add("Samuel");
        arraylist.add("Bob");
        arraylist.add("John");
        arraylist.add("Jane");
        System.out.println(arraylist.get(0));
        System.out.println(arraylist);

        System.out.println("-------------------------------------");
        Iterator<String> iter2 = arraylist.iterator();
        while (iter2.hasNext()){
            String s = iter2.next();
            System.out.println(s);
            if (s.equals("Samuel")) {
                iter2.remove();
            }
        }
        System.out.println(arraylist.size());
        System.out.println(arraylist);
        System.out.println("-------------------------------------");
        Map<Integer,String> stringMap = new HashMap<Integer, String>();
        stringMap.put(1, "Samuel");
        stringMap.put(2, "Bob");
        stringMap.put(3, "John");
        stringMap.put(4, "Jane");
        Set<Integer> keys2 = stringMap.keySet();
        System.out.println(keys2);
        System.out.println(stringMap.keySet());

        //als set
        System.out.println(stringMap.entrySet());
        Set<Map.Entry<Integer, String>> mapAsSet = stringMap.entrySet();
        //auch set
        System.out.println(mapAsSet);
        //als Map
        System.out.println(stringMap);
        Iterator<Map.Entry<Integer, String>> iter3 = stringMap.entrySet().iterator();
        System.out.println();
        for(Map.Entry<Integer, String> entry : stringMap.entrySet()) {
            if(entry.getValue() == "Samuel") {
                System.out.println(entry.getValue());
            }
        }
        System.out.println();
        while (iter3.hasNext()){
            Map.Entry<Integer, String> entry = iter3.next();
            System.out.println(entry);
            if(entry.getValue().equals("Samuel")) {
                iter3.remove();
            }
        }
        System.out.println(stringMap.size());
        Set<String> valueSet = new HashSet<>(stringMap.values());
        System.out.println(valueSet);
    }
}
