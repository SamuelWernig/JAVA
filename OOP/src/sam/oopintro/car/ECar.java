package sam.oopintro.car;

public class ECar extends Car{

    private  double batteryCapacity;
    public ECar(String name, double batteryCapacity) {
        super(name);
        this.batteryCapacity = batteryCapacity;
    }


    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

}
