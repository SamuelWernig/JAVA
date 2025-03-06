package at.htlle.sam.Carcollection;

public abstract class Vehilce {
    //Attribute
    private String model;
    private String brand;
    private int year;
    //Constructor
    public Vehilce(String model, String brand, int year) {
        this.model = model;
        this.brand = brand;
        this.year = year;

    }


    //Methods

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Vehilce other = (Vehilce) obj;
        if (this.getModel().equals(other.getModel()) && this.getBrand().equals(other.getBrand()) && this.getYear() == other.getYear()) {
            return true;
        }else {
            return false;
        }
    }

    public abstract String getDetails();

    //Getter && Setter

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
