package at.htlle.sam.test;
// Equals in Klasse Katze erklärt
public class Hund extends Tier{
    //Attribut
    private int bewBedarfStunden; //Nur Hund hat bewegungsbedarf, da Katzen immer raus können
    //Constructor
    public Hund(String name, int alter) {
        super(name, alter);
    }
    public Hund(){
    }
    //Methoden
    @Override
    public void gibLaut() {
        System.out.println("Wuff"); //Hund bellt
    }

    @Override
    public void hatGeburtstag() {
        this.setAlter(this.getAlter() + 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Hund other = (Hund)obj;

        if (this.getName().equals(other.getName()) && this.getAlter() == other.getAlter()){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Name: " + this.getName() + ", Alter: " + this.getAlter();
    }


    //Getter and Setter
    public int getBewBedarfStunden() {
        return bewBedarfStunden;
    }

    public void setBewBedarfStunden(int bewBedarfStunden) {
        this.bewBedarfStunden = bewBedarfStunden;
    }
}
