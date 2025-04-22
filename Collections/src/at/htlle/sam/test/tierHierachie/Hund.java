package at.htlle.sam.test.tierHierachie;

public class Hund extends Tier{
	
	public Hund(String name, String ownersName, Integer age){
		super(name, ownersName, age);
	}
	
	public void gibLaut(){
		String laut = "Wufffff";
		System.out.println(laut);
	}
}