package sam.oopintro.car;

public class Tyre {

	private String brand;
	private char type; // D(iagonal) || R(adial)
	private String dimension;
	private Car car;

	//Constructor
	public Tyre(String brand, char type, String dimension) {
		super();
		this.brand = brand;
		this.type = type;
		this.dimension = dimension;
	}

	//methods

	//getter & setter

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}




}