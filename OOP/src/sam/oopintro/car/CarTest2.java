package sam.oopintro.car;

public class CarTest2 {

	public static void main(String[] args) {

		Car myCar = new ECar("Mitsubishi", "blue", 0, 57.5);
		Car yourCar = new DirtyCar("Porsche", "cyan", 0, 50);

		Tyre uniTyre = new Tyre("Goodyear", 'R', "240/80");
//		Tyre alpTyre = new Tyre("Alpine", 'D', "180/80");

		myCar.setTyre(uniTyre);
		myCar.setTyre(null);
		yourCar.setTyre(uniTyre);

		System.out.println("MyCar Tyre Brand = "+myCar.getTyre());
		System.out.println("YourCar Tyre Brand = "+yourCar.getTyre());

		System.out.println("--------------------");

		ECar tesla = new ECar("Model 3","red", 57.5);
		System.out.println(tesla.getColor()+" "+tesla.getBatteryCapacity());

		DirtyCar ford1 = new DirtyCar("C-Max","red", 50);
		System.out.println(ford1.getColor()+" "+ford1.getFuelCapacity());

		DirtyCar ford2 = new DirtyCar("C-Max","red", 50);
		System.out.println(ford1.equals(ford2));

		System.out.println(ford1+" "+ford2);

	}

}