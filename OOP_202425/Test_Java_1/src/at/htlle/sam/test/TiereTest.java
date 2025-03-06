package at.htlle.sam.test;

public class TiereTest {
    public static void main(String[] args) {
        Person person1 = new Person("Samuel", "Wernig");

        Katze katze1 = new Katze("Sven", 5);
        Katze katze2 = new Katze("Steffi", 8);
        Hund hund1 = new Hund("Rocky", 10);
        Hund hund2 = new Hund("King", 7);

        person1.zeigeTiere();

        System.out.println(person1.neuesHaustier(katze1));
        System.out.println(person1.neuesHaustier(katze2));
        System.out.println(person1.neuesHaustier(hund1));
        System.out.println(person1.neuesHaustier(hund2));
        System.out.println();
        person1.zeigeTiere();
    }
}
