package sam.oopintro.car;

public class Car {
	
	//color, speed, ... are Attributes / Member variablen / Eigenschaften
	private String color;	
	private int speed;	// in km/h between 0 to 320
	private String name;
	private Tyre tyre;
	
	//Constructors
	
	public Car() {
	}
	
	public Car(String name) {
		this.name = name;
	}
	
	
	
	public Car(String color, int speed, String name) {
		this.color = color;
		this.speed = speed;
		this.name = name;
		
		setSpeed(speed);
	}



	//Methods
	
	public void accelerate(int increment) {
		setSpeed(speed+increment);
	}
	
	public int accelerate() {
		setSpeed(speed+1);		// "speed++" doesn't work because the variable would get higher after the method got used
		return this.speed;
	}
	
	public void brake(int increment) {
		setSpeed(speed-increment);
	}
	
	public int brake() {
		setSpeed(speed-1);
		return this.speed;
	}
	
	//getter and Setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = "jcjz";
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String c) {
		this.color = c;
		
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed < 0) {
			this.speed = 0;
		}else if(speed > 320) {
			this.speed = 320;
		}else {
			this.speed = speed;
		}
			
	}

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}
		
}
