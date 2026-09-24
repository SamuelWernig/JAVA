package at.htlle.sam.basics;

import com.sun.jdi.connect.spi.TransportService;

import java.util.*;

public class AutoMain {
    public static void main(String[] args) {
        Auto a =new Auto("Audi", 10);
        Auto b =new Auto("BMW", 20);
        Auto c = a; //Refferenz auf Auto a. Also es gibt 2 Objekte aber 3 Referenzen und danvon 2 von a.

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

        System.out.println("---------------------");

        System.out.println(Auto.getModellsBuild());

        Auto d = new Racecar("Porsche", 10, 400);

        System.out.println(Auto.getModellsBuild());

        System.out.println("---------------------");

        Auto e = new Auto("VW", 10);
        Auto f = new Auto("VW", 20);
        Auto g = new Auto("VW", 10);

        System.out.println(e.equals(f));
        System.out.println(e.equals(g));

        System.out.println("---------------------");

        List<Auto> carlist = new ArrayList<>();
        carlist.add(a);
        carlist.add(b);
        carlist.add(c);
        carlist.add(d);
        carlist.add(e);
        carlist.add(f);
        carlist.add(g);

        System.out.println(carlist);
        Collections.sort(carlist);
        System.out.println(carlist);
        System.out.println();
        System.out.println("Mit comperator und nach zwei sachen sortiert");

        carlist.sort(new CarComperator());
        System.out.println(carlist);

        System.out.println("---------------------");

        Set<Auto> carlist2 = new HashSet<>();
        carlist2.addAll(carlist);
        System.out.println(carlist2);
        Set<Auto> carlist3 = new TreeSet<>();
        carlist3.addAll(carlist);
        System.out.println(carlist3);
        Map<Integer, Auto> carlist4 = new HashMap<>();
        carlist4.put(1,a);
        carlist4.put(2,b);
        carlist4.put(3,c);
        carlist4.put(4,d);
        carlist4.put(5,e);
        carlist4.put(6,f);
        carlist4.put(7,g);
        System.out.println(carlist4);
        Map<Integer, Auto> carlist5 = new TreeMap<>();
        carlist5.put(1,a);
        carlist5.put(2,b);
        carlist5.put(3,c);
        carlist5.put(4,d);
        carlist5.put(5,e);
        carlist5.put(6,f);
        carlist5.put(7,g);
        System.out.println(carlist5);





    }
}
