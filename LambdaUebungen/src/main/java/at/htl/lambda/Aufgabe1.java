
package at.htl.lambda;

import java.util.List;
import java.util.function.Consumer;

public class Aufgabe1 {
    public static void main(String[] args) {
        List<String> namen = List.of("Anna", "Bernd", "Clara");

        // TODO: Ersetzen Sie den anonymen Consumer durch einen Lambda-Ausdruck
        namen.forEach( s -> System.out.println(s.toUpperCase()));
    }
}
