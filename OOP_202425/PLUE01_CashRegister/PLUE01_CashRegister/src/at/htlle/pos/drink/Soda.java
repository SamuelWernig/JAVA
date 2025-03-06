package at.htlle.pos.drink;

import at.htlle.pos.Drink;

public class Soda extends Drink {
    public static final String NAME = "SuperQuench";
    public static final int CALORIES = 50;
    public static final int COSTS_IN_CENT = 5;


    public Soda() {
        super(NAME, CALORIES, COSTS_IN_CENT);
    }
}
