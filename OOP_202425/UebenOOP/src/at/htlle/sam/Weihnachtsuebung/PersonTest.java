package at.htlle.sam.Weihnachtsuebung;
public class PersonTest {
    public static void main(String[] args) {

        Person person = new Person("Anna");

        Geschenk geschenk1 = new Geschenk("Schokolade");
        Geschenk geschenk2 = new Geschenk("Blumen");
        Geschenk geschenk3 = new Geschenk("Buch");

        person.geschenkHinzufuegen(geschenk1);
        person.geschenkHinzufuegen(geschenk2);
        person.geschenkHinzufuegen(geschenk3);

        System.out.println(person);

        person.geschenkLoeschen(geschenk1);
        System.out.println(person);

    }
}
