package at.htlle.sam.carcollection;

public abstract class Car implements Comparable<Car>{
    private String marke;
    private String modell;

	public Car(String marke, String modell){
		this.marke = marke;
		this.modell = modell;
	}

    @Override
    public int compareTo(Car o) {
        return this.modell.compareTo(o.modell);
    }

    @Override
    public String toString(){
        return modell;
    }


    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        modell = modell;
    }
}
