package at.htlle.sam.test;

public abstract class Tier {
    //Attribute
    private String name;        //Beide Haben Namen, ALter, Rasse und Futter
    private int alter;
    private String rasse;
    private String futter;

    //Constructor
    public Tier(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }
    public Tier(){ //Default Constructor

    }
    //Methoden
    public abstract void gibLaut(); //Abstracte Methoden definiert
    public abstract void hatGeburtstag();

    //Gettter und Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {  //Zum Namenändern
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getRasse() {
        return rasse;
    }

    public void setRasse(String rasse) {
        this.rasse = rasse;
    }

    public String getFutter() {
        return futter;
    }

    public void setFutter(String futter) {
        this.futter = futter;
    }


}




