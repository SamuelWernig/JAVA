package at.htlle.sam.tierHierachie;

public class Tier {
    private String name;

    public Tier(String name) {
        this.name = name;
    }

    public void gibLaut(){
        System.out.println(name +": Ein Geräusch");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
