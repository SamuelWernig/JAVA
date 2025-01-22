package at.htlle.pos.food;

import at.htlle.pos.Food;

public class Sausage extends Food {
    public static final String NAME = "Frankfurter";
    public static final int CALORIES = 300;
    public static final int COSTS_IN_CENT = 420;

    public Sausage() {
        super(NAME, CALORIES, COSTS_IN_CENT);
    }



}
