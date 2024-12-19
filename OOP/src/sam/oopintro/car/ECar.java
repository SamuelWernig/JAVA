package sam.oopintro.car;

public class ECar extends Car {

    private double batteryCapacity;

    // Constructors
    public ECar(String name, String color, double batteryCapacity) {
        super(name, color);
        this.batteryCapacity = batteryCapacity;
    }

    public ECar(String name, String color, int speed, double batteryCapacity) {
        super(name, color, speed);
        this.batteryCapacity = batteryCapacity;
    }

    // methods

    @Override
    public boolean equals(Object obj) {
        // 1 Objekt oder 2? Referenzvergleich
        if (this == obj)
            return true;

        // this und obj gleiche Klasse?
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        ECar other = (ECar) obj; // um auf Attribute zugreifen zu können

        if (this.getColor().equals(other.getColor())
                && this.getName().equals(other.getName())
                && this.batteryCapacity==other.batteryCapacity)
            return true;
        else
            return false;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

//	@Override
//	public boolean equals(Object obj) {
//		if (!super.equals(obj))
//			return false;
//		else {
//			ECar other = (ECar) obj;
//			if (this.batteryCapacity==other.batteryCapacity)
//				return true;
//			else
//				return false;
//		}
//	}
}