package at.htlle.sam.Carcollection;

public class CarcollectionTest {
    public static void main(String[] args) {
        Motorcycle motorcycle1 = new Motorcycle("Ninja H2R", "Kawasaki", 2015, "Sport");
        Motorcycle motorcycle2 = new Motorcycle("1000RR", "BMW", 2020, "Sport");
        Car car1 = new Car("F40", "Ferrari", 1980, 2);
        Car car2 = new Car("M3", "BMW", 2020, 4);
        CarCollectionMannager carCM = new CarCollectionMannager();
        carCM.addVehilce(motorcycle1);
        carCM.addVehilce(motorcycle2);
        carCM.addVehilce(car1);
        carCM.addVehilce(car2);
        System.out.println(carCM.getVehilces());

    }
}
