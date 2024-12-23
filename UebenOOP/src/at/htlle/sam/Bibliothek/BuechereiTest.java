package at.htlle.sam.Bibliothek;

public class BuechereiTest {
    public static void main(String[] args) {

        Novel novel1 = new Novel("Alles wird gut", "Thomas Evenue", 2000, "horror");
        Novel novel2 = new Novel("Besser geht es garnicht", "Jimmy Hank", 1980, "leid");
        NonFiction nonFiction1 = new NonFiction("Die Wissenschaft", "Thomas Even", 2003, "Physik");
        NonFiction nonFiction2 = new NonFiction("Ein Leben des Menschen", "Holly Molly", 1928, "Medizin");
        Library lib = new Library();
        if(!lib.addItem(novel1)){
            System.out.println("Konnte nicht hinzugefügt werden!");
        }
        if(!lib.addItem(novel2)){
            System.out.println("Konnte nicht hinzugefügt werden!");
        }
        if(!lib.addItem(nonFiction1)){
            System.out.println("Konnte nicht hinzugefügt werden!");
        }
        if(!lib.addItem(nonFiction2)){
            System.out.println("Konnte nicht hinzugefügt werden!");
        }

        lib.getItems();


        /*System.out.println(novel1.getDescription());
        System.out.println("------------------------------------------");
        System.out.println(novel2.getDescription());
        System.out.println("------------------------------------------");
        System.out.println(nonFiction1.getDescription());
        System.out.println("-----------------------------------------");
        System.out.println(nonFiction2.getDescription());*/




    }


}
