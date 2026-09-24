package at.htlle.sam.basics;

import java.util.Objects;

public class Auto implements Comparable<Auto>{
    private String marke;
    private int kmStand;
    private static int modellsBuild = 0;
    
    public Auto(String marke, int kmStand) {
        this.marke = marke;
        this.kmStand = kmStand;
        Auto.modellsBuild++; //Static variable zählt alle autos und racras mit sdie erzeugt werden, weil in racecar im konstruktor super() aufgerufen wird und da wird es auch erhöht.
    }



    /*public Auto(String marke) {//Zweiter konstrukter
        this.marke = marke;
    }
    */

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Auto.class){
            return false;
        }
        Auto auto = (Auto) obj;
        return this.marke.equals(auto.marke) && this.kmStand == auto.kmStand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marke, kmStand);
    }

    @Override
    public int compareTo(Auto o) {
        int markeVergleich = this.marke.compareTo(o.marke);
        if (markeVergleich != 0) return markeVergleich;
        return Integer.compare(this.kmStand, o.kmStand);
    }

    @Override
    public String toString() {
        return this.getMarke() + " " + this.kmStand;
    }

    public void fahren(int km){
        this.kmStand += km;
    }

    public String getMarke() {
        return marke;
    }
    public void setMarke(String marke) {
        this.marke = marke;
    }
    public int getKmStand() {
        return kmStand;
    }
    public void setKmStand(int kmStand) {
        this.kmStand = kmStand;
    }
    public static int getModellsBuild() {
        return modellsBuild;
    }
    public static void setModellsBuild(int modellsBuild) {
        Auto.modellsBuild = modellsBuild;
    }


}
