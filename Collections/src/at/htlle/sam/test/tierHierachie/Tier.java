package at.htlle.sam.test.tierHierachie;
import java.util.*;
public abstract class Tier implements Comparable<Tier>{
	
	private String name;
	private String ownersName;
	private Integer age;
	
	public Tier(String name, String ownersName, Integer age){
		this.name = name;
		this.ownersName = ownersName;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj){
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
	public int compareTo(Tier t){
		return this.getName().compareTo(t.getName());
	}
	
	@Override 
	public String toString(){
		return this.getName();
	}

	public abstract void gibLaut();
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setOwnersName(String ownersName){
		this.ownersName=ownersName;
	}
	
	public String getOwnersName(){
		return this.ownersName;
	}
	
	public void setAge(Integer age){
		this.age = age;
	}
	
	public Integer getAge(){
		return this.age;
	}
}