package sam.oopintro.car;

public class CarTest {

	public static void main(String[] args) {

		Car myCar = new ECar("Porsche", "red",93);
		myCar.setColor("red");
		myCar.setSpeed(100);
		
		Car yourCar = new burnerCar("red", "blue", 47);

		
		System.out.println(myCar.getColor()+" "+myCar.getSpeed());
		System.out.println(yourCar.getColor()+" "+yourCar.getSpeed());
		
		System.out.println("----------------------");
		
		Car[] carArray = new Car[5];
		carArray[0] = myCar;
		carArray[1] = yourCar;
		carArray[2] = yourCar;
		carArray[3] = myCar;
		carArray[4] = myCar;
		
		printArray(carArray);
		
		System.out.println("--------------");
		
		myCar.setSpeed(200);
		
		printArray(carArray);
		
		int actSpeed = myCar.accelerate();
		System.out.println(actSpeed);
		
		myCar.accelerate(20);
		System.out.println(myCar.getSpeed());
		
		myCar.brake(20);
		System.out.println(myCar.getSpeed());
		
		myCar.brake();
		System.out.println(myCar.getSpeed());
		
	}

	public static void printArray(Car[] carArray) {
		for (int i = 0; i < carArray.length; i++) {
			System.out.println(carArray[i].getColor()+" "+carArray[i].getSpeed());
		}
		
	}

}
