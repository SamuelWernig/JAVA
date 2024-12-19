package sam.oopintro.car;

public class DirtyCar extends Car {

    private int fuelCapacity;

    public DirtyCar(String name, String color, int fuelCapacity) {
        super(name, color);
        this.fuelCapacity=fuelCapacity;
    }

    public DirtyCar(String name, String color, int speed, int fuelCapacity) {
        super(name, color, speed);
        this.fuelCapacity=fuelCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        // 1 Objekt oder 2? Referenzvergleich
        if (this == obj)
            return true;

        // this und obj gleiche Klasse?
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        DirtyCar other = (DirtyCar) obj; // um auf Attribute zugreifen zu können

        if (this.getColor().equals(other.getColor())
                && this.getName().equals(other.getName())
                && this.fuelCapacity==other.fuelCapacity)
            return true;
        else
            return false;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }



}