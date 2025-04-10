package at.htlle.sam.buildings;

import at.htlle.sam.carcollection.Car;

import java.util.Objects;

public class Building implements Comparable<Building> {
	
	private Integer levels;
	private String name;
	private String adress;
	private Integer entries;

    public Building(Integer levels, String name, String adress, Integer entries) {
        this.levels = levels;
        this.name = name;
        this.adress = adress;
        this.entries = entries;
    }
	
	@Override
	public boolean equals(Object o) {
		if(this==o)
			return true;
		if(o==null || this.getClass() != o.getClass()){
			return false;
		}
		Building building = (Building) o;
		
		return this.getName().equals(building.getName()) && this.getLevels().equals(building.getLevels()) && this.getadress().equals(building.getadress());
        
    }
    @Override
    public int compareTo(Building o) {
        return this.name.compareTo(o.name);
    }
	@Override
	public int hashCode(){
        return Objects.hash(this.levels, this.name, this.adress, this.entries);
    }
	
	
    public Integer getLevels(){
		return levels;
	}
	public void setLevels(Integer levels){
		this.levels=levels;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getadress(){
		return adress;
	}
	
	public void setAdress(String adress){
		this.adress=adress;
	}
	
	public Integer getEntries(){
		return entries;
	}
	public void setEntries(Integer entries){
		this.entries=entries;
	}
}
