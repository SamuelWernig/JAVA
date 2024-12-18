package sam.oopintro.car;

public class burnerCar extends Car {

    private double fuelCapacity;

    public burnerCar(String name,String color, double fuelCapacity) {
        super(name, color);
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        burnerCar other = (burnerCar) obj;
        if(this.getName().equals(other.getName()) && this.getColor().equals(other.getColor()) && this.getFuelCapacity() == other.getFuelCapacity()){
            return true;
        }
        return false;
    }

}
