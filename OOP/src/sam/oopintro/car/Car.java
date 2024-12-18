package sam.oopintro.car;

import javax.naming.Name;
import javax.xml.namespace.QName;

public abstract class Car {
	
	//color, speed, ... are Attributes / Member variablen / Eigenschaften
	private String color;	
	private int speed;	// in km/h between 0 and 320
	private String name;
	private Tyre tyre;
	
	//Constructors

	public Car(String name,String color) {
		this.name = name;
		this.color = color;
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
		// Überprüfen, ob der übergebene Reifen bereits mit einem Auto verbunden ist
		if (tyre != null && tyre.getCar() != null) {
			// Wenn ja, trennen wir den Reifen vom vorherigen Auto
			tyre.getCar().tyre = null;
		}
		// Weisen dem aktuellen Auto den neuen Reifen zu
		this.tyre = tyre;// Verbindung von Car zu tyre
		// Stellen sicher, dass der Reifen auch auf dieses Auto verweist
		if (tyre != null) {
			this.tyre.setCar(this);//Verbindung von tyre zu Car
		}
	}

	@Override
	public boolean equals(Object obj) {
		//sind es zwei Objekte oder eines
		if (this == obj) {
			return true;
		}

		//ist obj != null und this und obj von einer Klasse
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		//Um auf Atribute zugreifen
		Car other = (Car) obj;

		if (this.color.equals(other.color) && this.name.equals(other.name)) {
			return true;
		}
		else {
            return false;
        }
    }
}
