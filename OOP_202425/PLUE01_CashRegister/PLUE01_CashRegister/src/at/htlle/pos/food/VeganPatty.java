package at.htlle.pos.food;

import at.htlle.pos.Food;

public class VeganPatty extends Food {
    public static final String NAME = "Vegan Bratling";
    public static final int CALORIES = 200;
    public static final int COSTS_IN_CENT = 340;

    public VeganPatty() {
        super(NAME, CALORIES, COSTS_IN_CENT);
    }
}
