package at.htlle.sam.test.tierHierachie;

import java.util.Comparator;

public class ReversedOrder implements Comparator<Tier>{
	
	@Override
	public int compare(Tier o1, Tier o2){
		return (o1.getName().compareTo(o2.getName()))*(-1);
	}
}