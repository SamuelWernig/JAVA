package at.htlle.sam.carcollection;

public class ECar extends Car{
	private double batteryCappasity;
	
	public ECar(String marke, String modell, double batteryCappasity) {
		super(marke, modell);
		this.batteryCappasity = batteryCappasity;
	}

	
	public void setBatteryCappasity(double batteryCappasity){
		batteryCappasity = batteryCappasity;
	}
	public double getBatteryCappasity(){
		return batteryCappasity;
		
	}
}
