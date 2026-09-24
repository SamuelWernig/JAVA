package at.htlle.sam.basics;

import java.util.Comparator;

public class CarComperator implements Comparator<Auto> {
    @Override
    public int compare(Auto a1, Auto a2) {
        int markeVergleich = a1.getMarke().compareTo(a2.getMarke());
        if (markeVergleich != 0) {
            return markeVergleich;// erst nach Name sortieren
        }
        return Integer.compare(a1.getKmStand(), a2.getKmStand());// dann nach km-Stand
    }
}
