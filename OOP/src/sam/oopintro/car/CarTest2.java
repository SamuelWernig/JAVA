package sam.oopintro.car;

public class CarTest2 {

	public static void main(String[] args) {
		
		Car myCar = new burnerCar("blue", 45);
		Car yourCar = new ECar("Porsche" , 57.5);
		
		Tyre uniTyre = new Tyre("Goodyear", 'R', "240/80");
		myCar.setTyre(uniTyre);
		myCar.setTyre(null);
		yourCar.setTyre(uniTyre);
		
		System.out.println("MyCar Tyre Brand = "+myCar.getTyre());
		System.out.println("YourCar Tyre Brand = "+yourCar.getTyre());

		System.out.println("------------------------------------------");

		ECar tesla = new ECar("Model3", 57.5);

		burnerCar ford = new burnerCar("red", 50);
		burnerCar ford2 = new burnerCar("red", 50);

		System.out.println(ford.getColor()+" "+ ford.getFuelCapacity());
		System.out.println(ford2.getColor()+" "+ ford2.getFuelCapacity());
		System.out.println(ford.equals(ford2));
		System.out.println(ford);
		System.out.println(ford2);

	}

}
