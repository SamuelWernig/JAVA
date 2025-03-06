package at.htlle.pos.drink;

import at.htlle.pos.Drink;

public class Beer extends Drink {
    public static final String NAME = "Duff";
    public static final int CALORIES = 218;
    public static final int COSTS_IN_CENT = 560;

    public Beer() {
        super(NAME, CALORIES, COSTS_IN_CENT);
    }
}
