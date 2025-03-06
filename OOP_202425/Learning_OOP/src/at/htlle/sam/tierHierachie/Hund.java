package at.htlle.sam.tierHierachie;

public class Hund extends Tier {
    public Hund(String name) {
        super(name);
    }

    @Override
    public void gibLaut() {
        System.out.println(getName() +" bellt: Wuff Wuff");
    }
}
