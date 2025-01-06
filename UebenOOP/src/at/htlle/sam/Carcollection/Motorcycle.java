package at.htlle.sam.Carcollection;

public class Motorcycle extends Vehilce {
    //Attribute
    private String type;
    //Constructor
    public Motorcycle(String model, String brand, int year, String type) {
        super(model,brand,year);
        this.type = type;

    }



    //Methods
    @Override
    public String getDetails() {
        String output = "";
        output += this.getModel() + " " + this.getBrand() + " " + this.getYear() + " " + this.getType() + "\n";
        return output;
    }
    //Getter && Setter

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
