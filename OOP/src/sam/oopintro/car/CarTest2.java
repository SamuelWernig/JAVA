package sam.oopintro.car;

public class CarTest2 {

	public static void main(String[] args) {
		
		Car myCar = new burnerCar("blue", 45);
		Car yourCar = new ECar("Porsche" , 57.5);
		
		Tyre uniTyre = new Tyre("Goodyear", 'R', "240/80");
		myCar.setTyre(uniTyre);
		yourCar.setTyre(uniTyre);
		
		System.out.println("MyCar Tyre Brand = "+myCar.getTyre());
		System.out.println("YourCar Tyre Brand = "+yourCar.getTyre());

		System.out.println("------------------------------------------");

		ECar tesla = new ECar("Model3", 57.5);

		burnerCar ford = new burnerCar("rot", 50);
		System.out.println(ford.getColor()+" "+ ford.getFuelCapacity());



	}

}
