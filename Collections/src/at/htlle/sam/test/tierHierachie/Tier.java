package at.htlle.sam.test.tierHierachie;
import java.util.*;
public abstract class Tier implements Comparable<Tier>{
	private String name;
	
	public Tier(String name){
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		Tier t = (Tier) obj;
		if(this.getName().equals(t.getName())){
			return true;
		}
        return false;
    }
	
	@Override
	public int hashCode(){
		return Objects.hash(name);
	}
	
	@Override
	public int compareTo(Tier other) {
        return this.name.compareTo(other.name);
    }

	public abstract void geraeuschMachen();
	
	public void essen(){
		System.out.println(name + " isst.");
	}
	
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}