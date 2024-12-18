package sam.oopintro.car;

public class CarTest2 {

	public static void main(String[] args) {
		
		Car myCar = new burnerCar("Porsche", "blue",44);
		Car yourCar = new ECar("Porsche" , "red", 57);
		
		Tyre uniTyre = new Tyre("Goodyear", 'R', "240/80");
		myCar.setTyre(uniTyre);
		myCar.setTyre(null);
		yourCar.setTyre(uniTyre);
		
		System.out.println("MyCar Tyre Brand = "+myCar.getTyre());
		System.out.println("YourCar Tyre Brand = "+yourCar.getTyre());

		System.out.println("------------------------------------------");

		ECar tesla = new ECar("Model3", "red", 52);

		burnerCar ford = new burnerCar("Ferrari", "red", 57);
		burnerCar ford2 = new burnerCar("Ferrari", "red", 57);

		System.out.println(ford.getColor()+" "+ ford.getFuelCapacity());
		System.out.println(ford2.getColor()+" "+ ford2.getFuelCapacity());
		System.out.println(ford.equals(ford2));
		System.out.println(ford);
		System.out.println(ford2);
		System.out.println("------------------------------------------");

		ECar tesla1 = new ECar("Tesla Model Y", "red", 45);
		ECar tesla2 = new ECar("Tesla Model Y", "red", 45);
		System.out.println(tesla1.equals(tesla2));
		System.out.println(tesla1);
		System.out.println(tesla2);

	}

}
