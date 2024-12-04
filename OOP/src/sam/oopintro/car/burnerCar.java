package sam.oopintro.car;

public class burnerCar  extends Car {

    private double fuelCapacity;

    public burnerCar(String color, double fuelCapacity) {
        super(color);
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

}
