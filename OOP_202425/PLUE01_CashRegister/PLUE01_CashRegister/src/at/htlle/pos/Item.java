package at.htlle.pos;

public abstract class Item {
    // instance variables
    protected String name;
    private int costsInCent;

    // constructor
    public Item(String name, int costsInCent){
        this.name = name;
        this.costsInCent = costsInCent;
        // what shall we do with the parameters?
    }

    public int getCostsInCent() {
        return costsInCent;
    }



    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +": "+ getCostsInEuro()+"€";
    }

    protected abstract double getCostsInEuro();

    public abstract String toDetailedString();

    public abstract int getCalories();

}
