package org.example;

public class ECar extends Car{
	private double batteryCappasity;
	
	public ECar(String marke, String modell, double batteryCappasity) {
		super(marke, modell);
		this.batteryCappasity = batteryCappasity;
	}

	
	public void setBatteryCappasity(double batteryCappasity){
		this.batteryCappasity = batteryCappasity;
	}
	public double getBatteryCappasity(){
		return batteryCappasity;
		
	}
}
