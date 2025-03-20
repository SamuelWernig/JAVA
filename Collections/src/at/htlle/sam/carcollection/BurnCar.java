package at.htlle.sam.carcollection;

public class BurnCar extends Car{
	private double fuelCappasity;
	
	public BurnCar(String marke, String modell, double fuelCappasity){
		super(marke, modell);
		this.fuelCappasity = fuelCappasity;
	}
	
	
	
	public void setFuel(double fuelCappasity){
		fuelCappasity = fuelCappasity;
	}
	public double getFuelCappasity(){
		return fuelCappasity;
		
	}
}
