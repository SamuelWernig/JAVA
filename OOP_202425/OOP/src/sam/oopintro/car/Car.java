package sam.oopintro.car;

public class Car {

	private String name;
	private String color;
	private int speed; // in km/h between 0 and 320
	private Tyre tyre;

	//Constructors
	public Car() {
	}

	public Car(String name, String color) {
		this.name=name;
		this.color=color;
	}

	public Car(String name, String color, int speed) {
		this.name = name;
		this.color = color;
		setSpeed(speed);
	}

	//methods

	@Override
	public boolean equals(Object obj) {
		// 1 Objekt oder 2? Referenzvergleich
		if (this==obj)
			return true;

		//this und obj gleiche Klasse?
		if (obj==null || this.getClass()!=obj.getClass())
			return false;

		Car other = (Car) obj; //um auf Attribute zugreifen zu können

		if (this.color.equals(other.color) &&
				this.name.equals(other.name))
			return true;
		else
			return false;

	}

	public void accelerate(int increment) {
		setSpeed(speed+increment);
	}

	public int accelerate() {
		setSpeed(speed+1);
		return this.speed;
	}

	public void brake(int increment) {
		setSpeed(speed-increment);
	}

	public int brake() {
		setSpeed(speed-1);
		return this.speed;
	}

	//getter and setter

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed < 0)
			this.speed = 0;
		else if (speed > 320)
			this.speed = 320;
		else
			this.speed=speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {

		if (tyre != null && tyre.getCar()!=null) {
			tyre.getCar().tyre=null;
		}
		this.tyre = tyre; //Verbindung von Car zu Tyre
		if (tyre != null)
			this.tyre.setCar(this); //Verbindung von Tyre zu Car
	}



}