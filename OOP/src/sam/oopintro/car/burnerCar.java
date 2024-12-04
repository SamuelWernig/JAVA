package sam.oopintro.car;

public class burnerCar  extends Car {

    private double fuelCapacity;

    public burnerCar(String name, double fuelCapacity) {
        super(name);
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
}
