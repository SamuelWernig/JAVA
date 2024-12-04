package sam.oopintro.car;

public class CarTest2 {

	public static void main(String[] args) {
		
		Car myCar = new Car("blue", 0, "Mitsubishi");
		Car yourCar = new Car("cyan", 0, "Porsche");
		
		Tyre uniTyre = new Tyre("Goodyear", 'R', "240/80");
		myCar.setTyre(uniTyre);
		yourCar.setTyre(uniTyre);
		
		System.out.println("MyCar Tyre Brand = "+myCar.getTyre());
		System.out.println("YourCar Tyre Brand = "+yourCar.getTyre());

	}

}
