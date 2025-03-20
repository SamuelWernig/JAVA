package at.htlle.sam.beispiel1;
import java.util.ArrayList;
public class Bsp1withArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1. String");
        list.add("2. String");
        list.add("3. String");
        list.add("4. String");
        list.add("5. String");
        list.remove("1. String");
        System.out.println(list.get(0));
        System.out.println(list.indexOf("2. String"));
        System.out.println(list.size());



    }
}
