package at.htlle.sam.test.tierHierachie;

import at.htlle.sam.carcollection.SortDowntoUp;

import java.util.*;

public class Main{
	public static void main(String[] args){
		
		Tier t1 = new Katze("Melly", "Samuel", 2);
		Tier t2 = new Katze("Molly", "Samuel", 10);
		Tier t3 = new Hund("Rex", "Samuel", 6);
		Tier t4 = new Hund("Thunder", "Samuel", 3);
		
		List<Tier> tierList = new ArrayList<>();
		tierList.add(t1);
        tierList.add(t2);
        tierList.add(t3);
        tierList.add(t4);
        
		System.out.println(tierList);
		Collections.sort(tierList, new ReversedOrder());
        System.out.println(tierList);
        System.out.println("---------------------------------");
		
		Map<Integer, Tier> tierMap = new HashMap<Integer, Tier>();
		
		tierMap.put(1, t1);
		tierMap.put(2, t2);
		tierMap.put(3, t3);
		tierMap.put(4, t4);
		
		System.out.println(tierMap);
		
		Iterator<Tier> iter = tierList.iterator();
        System.out.println();
		while(iter.hasNext()){
			Tier t = iter.next();
            if ("Melly".equals(t.getName()))
				iter.remove();
            else{
                System.out.println(t);
            }

		}
		
		
	}
}
