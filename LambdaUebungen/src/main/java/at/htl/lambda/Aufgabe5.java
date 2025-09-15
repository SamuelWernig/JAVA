
package at.htl.lambda;

import java.util.List;
import java.util.function.Supplier;

public class Aufgabe5 {
    public static void main(String[] args) {
        List<String> namen = List.of("Anna", "Bernd", "Clara");

        // TODO: Ersetzen Sie den anonymen Consumer durch eine Methodenreferenz
        namen.forEach(s -> System.out.println(s));

        // TODO: Ersetzen Sie den anonymen Supplier durch eine Konstruktorreferenz
        Supplier<List<String>> listSupplier = () -> new java.util.ArrayList<>();

        System.out.println(listSupplier.get().getClass());
    }
}
