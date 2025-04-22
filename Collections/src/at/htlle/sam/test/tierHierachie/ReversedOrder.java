package at.htlle.sam.test.tierHierachie;

import java.util.Comparator;

public class ReversedOrder implements Comparator<Tier> {
	@Override
	public int compare(Tier t1, Tier t2){
		return (t1.getName().compareTo(t2.getName()))*(-1);
	}
}
