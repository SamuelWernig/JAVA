package at.htlle.sam.test.tierHierachie;

public class Hund extends Tier{
	
	public Hund(String name){
		super(name);
	}
	
	@Override
	public void geraeuschMachen(){
		System.out.println("Wuff");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		Hund h = (Hund) obj;
		if(this.getName().equals(h.getName())){
			return true;
		}
        return false;
    }
}