package at.htlle.sam.Bus_OOP;

public class Bus {
    private int peopleNumber;
    private String name;

    public Bus (int peopleNumber, String name) {
        this.peopleNumber = peopleNumber;
        this.name = name;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }
    public int getPeopleNumber() {
        return peopleNumber;
    }


}
