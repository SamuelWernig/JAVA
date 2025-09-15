
package at.htl.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Aufgabe4 {
    public static void main(String[] args) {
        List<String> animals = List.of("Hund", "Katze", "Maus");

        // TODO: Ersetzen Sie die Function durch einen Lambda-Ausdruck
        Function<String, Integer> length = s -> s.length();

        List<Integer> lenghts = animals.stream()
                                    .map(length)
                                    .collect(Collectors.toList());

        System.out.println(lenghts);
    }
}
