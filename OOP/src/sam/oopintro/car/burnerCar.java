package sam.oopintro.car;

public class burnerCar  extends Car {

    private int fuelCapacity;

    public burnerCar(String name, int fuelCapacity) {
        super(name);
        this.fuelCapacity = fuelCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
}
