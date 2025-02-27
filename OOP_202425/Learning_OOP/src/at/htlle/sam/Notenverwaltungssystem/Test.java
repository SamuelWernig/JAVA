package at.htlle.sam.Notenverwaltungssystem;

public class Test {
    public static void main(String[] args){
        double[] notenSuS = {2,4,6,7,4,2,1};
        NotenVerwaltung Noten = new NotenVerwaltung(notenSuS);
        System.out.println(Noten.berechneDurchschnitt());
        System.out.println(Noten.findMaxNote());
        System.out.println(Noten.findMinNote());
    }
}
