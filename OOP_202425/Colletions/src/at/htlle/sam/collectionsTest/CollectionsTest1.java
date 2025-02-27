package at.htlle.sam.collectionsTest;
import java.util.*;
import java.util.jar.JarOutputStream;

public class CollectionsTest1 {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Vector<String> stringVector = new Vector<>();
        LinkedList<String> linkedList = new LinkedList<>();

        String[] myStringArray = new String[10];
        for (int i = 0; i < 10; i++) {
            myStringArray[i] = "My array string " + i;

        }


        ArrayList<String> importTasks = new ArrayList<>();
        importTasks.add("First Task");
        importTasks.add("Second Task");
        importTasks.add("Third Task");
        System.out.println("compare output of Array vs. Array-list");

        System.out.println("For each: ");
        for (String string : stringVector) {
            System.out.println(string);

        }

        System.out.println("With Arrays.toString: ");
        System.out.println(Arrays.toString(myStringArray));

        System.out.println("arrayList keeps the order of inserts");
        System.out.println(importTasks);

        Collections.shuffle(importTasks);
        System.out.println("arrayList shuffle");
        System.out.println(importTasks);

        System.out.println("sorting");
        importTasks.sort(Collections.reverseOrder());
        System.out.println(importTasks);

        System.out.println("Sublist");
        System.out.println(importTasks.subList(0, 2));




    }
}
