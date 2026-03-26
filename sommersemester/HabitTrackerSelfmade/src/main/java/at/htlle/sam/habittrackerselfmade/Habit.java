package at.htlle.sam.habittrackerselfmade;

public class Habit {
    private Integer id;
    private String name;
    private String category;
    private String targetPerWeek;

    Habit(Integer id, String name, String category, String targetPerWeek) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.targetPerWeek = targetPerWeek;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTargetPerWeek() {
        return targetPerWeek;
    }

    public void setTargetPerWeek(String targetPerWeek) {
        this.targetPerWeek = targetPerWeek;
    }
}
