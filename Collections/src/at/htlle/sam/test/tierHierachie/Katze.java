package at.htlle.sam.test.tierHierachie;

public class Katze extends Tier{
	
	public Katze(String name){
		super(name);
	}
	
	@Override
	public void geraeuschMachen(){
		System.out.println("Miau");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		Katze k = (Katze) obj;
		if(this.getName().equals(k.getName())){
			return true;
		}
        return false;
    }
}