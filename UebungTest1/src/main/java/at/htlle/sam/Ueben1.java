package at.htlle.sam;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
public class Ueben1 {
    public static void main(String[] args) {
        //Lambda und StreamAPI
        List<Integer> integerList = List.of(1,2,3,4,5,6);

        integerList.forEach( n -> System.out.println("Zahl: " + n));
        System.out.println();

        integerList.stream()
                .filter(n -> n%2 == 0)
                .forEach(System.out::println);

        System.out.println();
        List<Integer> quadrate = integerList.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(quadrate);

        System.out.println();
        double durchschnitt = integerList.stream()
                .mapToInt(n -> n)
                .average()
                .getAsDouble();
        System.out.println(durchschnitt);

        System.out.println();
        int max = integerList.stream().max((n1, n2)-> Integer.compare(n1, n2)).get();
        int min = integerList.stream().min((n1, n2)-> Integer.compare(n1, n2)).get();
        System.out.println("Max: "+max+"; Min: "+min);

        System.out.println();
        List<Integer> doppelteInteger = integerList.stream()
                .filter(n -> n%2 == 0)
                .collect(Collectors.toList());
        System.out.println(doppelteInteger);

        System.out.println();
        int summe = integerList.stream()
                .reduce(0, (a, b) -> a+b);
        System.out.println(summe);

        System.out.println();
        List<String> stringZahlen = integerList.stream()
                .map(n -> "Zahl: "+n)
                .collect(Collectors.toList());
        System.out.println(stringZahlen);

        System.out.println();
        List<Integer> zahlenGroesser3 = integerList.stream()
                .filter(n -> n>3)
                .collect(Collectors.toList());
        System.out.println(zahlenGroesser3);

        System.out.println();
        List<String> tierListe = new ArrayList<String>(List.of("Hase", "Pferd", "Hund", "Löwe", "Wolf"));
        tierListe.sort((a, b) -> a.compareTo(b));
        System.out.println(tierListe);

        System.out.println();
        //Lambda Functional Interface
        Predicate<Integer> istGerade = n -> n%2 == 0;
        List<String> geradeZahlen = integerList.stream()
                .filter(istGerade)
                .map(n -> "Zahl: "+n+" ist gerade")
                .collect(Collectors.toList());
        System.out.println(geradeZahlen);
        //oder für einzelne Zahlen(Bei Predicate: test):
        System.out.println(istGerade.test(4));

        System.out.println();
        Function<Integer, Integer> quadratBerechnen = n -> n*n;
        List<Integer> quadrateMitFunction = integerList.stream()
                .map(quadratBerechnen)
                .collect(Collectors.toList());
        System.out.println(quadrateMitFunction);
        //oder wieder für einzelne Zahlen(Bei Function: apply):
        System.out.println(quadratBerechnen.apply(3));
        //accept
        System.out.println();
        Consumer<String> printString = s -> System.out.println("Hallo " + s);
        printString.accept("Samu");
        //get
        System.out.println();
        Supplier<Integer> randomZahl = () -> (int) Math.round((Math.random() * 9) +1);
        System.out.println(randomZahl.get());

        System.out.println();
        Predicate<Integer> istUngerade = n -> n%2 == 1;
        List<Integer> ungerade = integerList.stream()
                .filter(istUngerade)
                .collect(Collectors.toList());
        System.out.println(ungerade);

        System.out.println();
        Function<Integer, String> zahlAlsString = n -> "Zahl: "+n;
        List<String> stringList = integerList.stream()
                .map(zahlAlsString)
                .collect(Collectors.toList());
        System.out.println(stringList);

        System.out.println();
        Consumer<Integer> ausgabe = n -> System.out.println("Wert: " + n);
        integerList.forEach(ausgabe);

        System.out.println();
        Supplier<List<String>> nameSupplier = () -> List.of("Samu", "Elias", "Urschinger", "Kevin");
        System.out.println(nameSupplier.get());

        //anonyme Klasse
        System.out.println();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hallo");
            }
        };
        r.run();


    }
}