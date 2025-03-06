package at.htlle.pos;

public class Drink extends Item {
    // instance variables
    private int calories;

    public Drink(String name, int calories, int costsInCent) {
        super(name, costsInCent);
        this.calories = calories;
    }

    @Override
    protected double getCostsInEuro() {
        double costsInEuro = getCostsInCent()/100;
        return costsInEuro;
    }

    @java.lang.Override
    public String toDetailedString() {
        return "Name: "+ getName() +", Calories: "+ calories + ", Costs: "+ getCostsInEuro()+"€";
    }

    @java.lang.Override
    public int getCalories() {
        return calories;
    }


    // we also want to return a detailed String - see assignament for description

}
