package at.htlle.sam.test.tierHierachie;

public class Katze extends Tier{
    
	public Katze(String name, String ownersName, Integer age){
		super(name, ownersName, age);
	}
	
	public void gibLaut(){
		String laut = "Miauuuu";
		System.out.println(laut);
	}
	
}