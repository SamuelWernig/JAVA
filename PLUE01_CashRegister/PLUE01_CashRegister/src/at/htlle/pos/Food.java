package at.htlle.pos;

/**
 * The Food class represents a typical food-item the snackbar sells
 * and which can be processed with the CashRegister
 */
public class Food extends Item {
    private int calories;

    public Food(String name, int costsInCent, int calories) {
        super(name, costsInCent);
        this.calories = calories;
    }

    @Override
    protected double getCostsInEuro() {
        double costsInEuro = getCostsInCent()/100;
        return costsInEuro;

    }

    // constructor?
    // cannot be too hard - check the other class like Drink how it's done there!


    // detailed String  - check assingment and other classes like Drink
    @Override
    public String toDetailedString() {
       return "Name: "+ getName() +", Calories: "+ calories + ", Costs: "+ getCostsInEuro()+"€";
    }

    @java.lang.Override
    public int getCalories() {
        return calories;
    }
}
