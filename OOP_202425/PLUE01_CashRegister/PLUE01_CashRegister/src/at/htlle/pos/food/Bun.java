package at.htlle.pos.food;

import at.htlle.pos.Food;

public class Bun extends Food {
    public static final String NAME = "Semmerl";
    public static final int CALORIES = 180;
    public static final int COSTS_IN_CENT = 200;

    public Bun() {
        super(NAME, CALORIES, COSTS_IN_CENT);
    }
}
