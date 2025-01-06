package at.htlle.sam.Carcollection;

public class Car extends Vehilce{
    //Attribute
    private int numberOfDoors;
    //Constructor
    public Car(String model, String brand, int year, int numberOfDoors) {
        super(model,brand,year);
        this.numberOfDoors = numberOfDoors;

    }


    //Methods
    @Override
    public String getDetails() {
        String output = "";
        output += this.getModel() + " " + this.getBrand() + " " + this.getYear() + " " + this.getNumberOfDoors() + "\n";


        return output;
    }
    //Getter && Setter

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
