package at.htlle.sam.produkteundpreise;

import com.sun.source.tree.Tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

public class Geschaeft{

    private HashMap<String, Double> map = new HashMap<>();

    public void newProdukt(String name, double price){
        map.put(name, price);
    }
    public void getProdukt(String name){
        if(map.containsKey(name)){
            System.out.println(map.get(name));
        }
        else{
            System.out.println("No such produkt");
        }
    }
    public void einkaufsliste(HashMap<String, Double> map){
        Double price =0.0;
        TreeMap<String, Double> treeMap = new TreeMap<>(map);
        for(String key:map.keySet()){
            price += map.get(key);
        }
        System.out.println(price);
        System.out.println(treeMap);
    }

    public static void main(String[] args) {

        Geschaeft geschaeft = new Geschaeft();
        geschaeft.newProdukt("Cola", 1.50);
        geschaeft.newProdukt("Brot", 6.50);

        geschaeft.einkaufsliste(geschaeft.map);

    }
}
