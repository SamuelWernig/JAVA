
package at.htl.lambda;

import java.util.List;
import java.util.function.Predicate;

public class Aufgabe3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 7, 10, 14, 21, 28);

        // TODO: Ersetzen Sie den Predicate durch einen Lambda-Ausdruck
        Predicate<Integer> divideableSeven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 7 == 0;
            }
        };

        for (Integer number : numbers) {
            if (divideableSeven.test(number)) {
                System.out.println(number);
            }
        }
    }
}
