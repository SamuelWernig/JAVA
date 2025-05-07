package at.htlle.sam.telefonbuch;

import java.util.*;

public class Telefonbuch {
    private HashMap<String, String> map = new HashMap<String, String>();

    public void newEntry(String name, String number){
        map.put(name,number);
    }
    public void showNumber(String name){
        if (map.containsKey(name)) {
            System.out.println(map.get(name));
        } else {
            System.out.println("No such number");
        }
    }
    public void deleteEntry(String name){
        map.remove(name);
    }

    public static void main(String[] args){
        Telefonbuch telefonbuch = new Telefonbuch();

        telefonbuch.newEntry("Samuel", "0660 7784101");
        telefonbuch.newEntry("Anna", "0661 7784101");
        telefonbuch.showNumber("Samuel");


    }

}
