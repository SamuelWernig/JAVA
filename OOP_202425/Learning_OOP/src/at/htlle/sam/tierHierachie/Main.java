package at.htlle.sam.tierHierachie;

public class Main {
    public static void main(String[] args) {

        Tier[] tiere = {

                new Hund("Bello"),
                new Tier("Rex"),
        };


        for (Tier tier : tiere) {
            tier.gibLaut();
        }
    }
}
