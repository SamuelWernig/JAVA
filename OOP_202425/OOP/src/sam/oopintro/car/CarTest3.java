package sam.oopintro.car;

public class CarTest3 {

    public static void main(String[] args) {

        Object ecar1 = new ECar("Tesla", "weiß", 57.5);
        Object ecar2 = new ECar("Tesla", "weiß", 57.5);

        System.out.println(ecar1.equals(ecar2));
        System.out.println(ecar1);
        System.out.println(ecar2);

        System.out.println(ecar1.hashCode());
        System.out.println(ecar2.hashCode());

        System.out.println(ecar1.);

    }

}
