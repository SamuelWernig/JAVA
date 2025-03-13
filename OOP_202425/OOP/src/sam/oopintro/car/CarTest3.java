package sam.oopintro.car;

import java.util.Arrays;

public class CarTest3 {

    public static void main(String[] args) {

        ECar ecar1 = new ECar("Alpha", "weiß", 17.5);
        ECar ecar2 = new ECar("Beta", "weiß", 45);
        ECar ecar3 = new ECar("Cetar", "weiß", 57.5);
        ECar ecar4 = new ECar("Detar", "weiß", 53.5);
        ECar ecar5 = new ECar("Eetar", "weiß", 27.5);

        System.out.println(ecar1.equals(ecar2));
        System.out.println(ecar1);
        System.out.println(ecar2);

        System.out.println(ecar1.hashCode());
        System.out.println(ecar2.hashCode());

        System.out.println(ecar1.compareTo(ecar2));
        ECar[] cars = {ecar1, ecar2, ecar3, ecar4, ecar5};
        Arrays.sort(cars);
        for (ECar ecar : cars) {
            System.out.println(ecar.getName());
        }
        System.out.println("--------------------------------------------------");
        Arrays.sort(cars, new CompByBatteryCapacity());
        for (ECar ecar : cars) {
            System.out.println(ecar.getName());
        }
    }
}
