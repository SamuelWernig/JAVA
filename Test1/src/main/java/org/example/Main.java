package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args){
		ArrayList<Car> arrayList = new ArrayList<>();
        LinkedList<Car> linkedList = new LinkedList<>();
		HashSet<Car> hashSet = new HashSet<>();
		TreeSet<Car> treeSet = new TreeSet<>();

		ECar ecar1 = new ECar("Tesla", "VD", 32);
		ECar ecar2 = new ECar("VW", "XDIED", 49);
		BurnCar burnCar1 = new BurnCar("Audi", "DVD", 54);
		BurnCar burnCar2 = new BurnCar("VW", "MVIER", 50); /*{
			@Override
			public int compareTo(Car car){
				return this.getMarke().compareTo(car.getMarke());
			}
		};*/

		arrayList.add(ecar1);
		arrayList.add(ecar2);
		arrayList.add(burnCar1);
		arrayList.add(burnCar2);
		/*arrayList.add(ecar1);
		arrayList.add(ecar2);
		arrayList.add(burnCar1);
		arrayList.add(burnCar2);*/


		linkedList.add(ecar1);
		linkedList.add(ecar2);
		linkedList.add(burnCar1);
		linkedList.add(burnCar2);
		/*linkedList.add(ecar1);
		linkedList.add(ecar2);
		linkedList.add(burnCar1);
		linkedList.add(burnCar2);*/



		//In Sets sind keine duplikate
		//Hier wird speicher Adresse geprüft
		hashSet.add(ecar1);
		hashSet.add(ecar2);
		hashSet.add(burnCar1);
		hashSet.add(burnCar2);
		hashSet.add(ecar1);
		hashSet.add(ecar2);
		hashSet.add(burnCar1);
		hashSet.add(burnCar2);
		//In TreeSet wird nur mit Comparable verglichen
		//Werden je nach Compareto Methode hinzugefügt oder nicht
		treeSet.add(ecar1);
		treeSet.add(ecar2);
		treeSet.add(burnCar1);
		treeSet.add(burnCar2);
		treeSet.add(ecar1);
		treeSet.add(ecar2);
		treeSet.add(burnCar1);
		treeSet.add(burnCar2);


		System.out.println(arrayList);
		System.out.println(linkedList);
		System.out.println(hashSet);
		System.out.println(treeSet);

		System.out.println("-------------------------------------");
		Collections.sort(arrayList);
		System.out.println(arrayList);
		System.out.println("-------------------------------------");
		Collections.sort(arrayList, new SortDowntoUp());
		System.out.println(arrayList);
		
	}

}
