package at.htlle.sam.tierHierachie;

public class Main {
    public static void main(String[] args) {

        Tier[] tiere = {

                new Hund("Bello"),
                new Hund("Rex"),
        };


        for (Tier tier : tiere) {
            tier.gibLaut();
        }
    }
}
