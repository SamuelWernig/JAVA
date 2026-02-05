package at.htlle.sam.sandwich;

public class Main {
    public static void main(String[] args) {

        Sandwich sandwich1 = new Sandwich.Builder("Weisbrot", "Chedder", "Hotsauce")
                .newPatty("Beef")
                .newHam("Bacon")
                .build();

        System.out.println(sandwich1);

    }
}
