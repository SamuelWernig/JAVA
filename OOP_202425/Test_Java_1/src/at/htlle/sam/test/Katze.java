package at.htlle.sam.test;

public class Katze extends Tier{
    //Denke nicht, dass hier ein extra Attribut nötig ist da Katzen auch von selbst raus können und auch wieder zurück kommen
    //Constructor
    public Katze(String name, int alter) {
        super(name, alter);
    }
    public Katze(){
    }

    @Override
    public void gibLaut() {
        System.out.println("Miau"); //Katze Miaut
    }

    @Override
    public void hatGeburtstag() {   //Ändert das Alter um +1
        this.setAlter(this.getAlter() + 1);
    }

    @Override
    public boolean equals(Object obj) {     //Vergleichungsmethode, wird aber nicht in meinem Code benötigt aber man könnte es in der main verwenden um zu sehen ob zwei haustiere gleich sind
        if (this == obj){   //Überprüft ob es das gleiche object ist
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){   //Falls das obj null ist bricht es ab sonnst kommt eine NullPointException
            return false;
        }
        Katze other = (Katze)obj; //Casten weil wir auf die Attribute zugreifen wollen

        if (this.getName().equals(other.getName()) && this.getAlter() == other.getAlter()){ // Meine Definition von gleich
            return true;
        }
        return false;
    }
    @Override
    public String toString() {  //toString Methode
        return "Name: " + this.getName() + ", Alter: " + this.getAlter();
    }

}
