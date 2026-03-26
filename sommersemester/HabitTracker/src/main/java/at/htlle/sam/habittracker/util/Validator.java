package at.htlle.sam.habittracker.util;

public class Validator {

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidCategory(String category) {
        return category != null && !category.trim().isEmpty();
    }

    public static boolean isValidTargetPerWeek(int target) {
        return target > 0 && target <= 7;
    }

    public static boolean isValidHabit(String name, String category, int targetPerWeek) {
        return isValidName(name)
                && isValidCategory(category)
                && isValidTargetPerWeek(targetPerWeek);
    }
}