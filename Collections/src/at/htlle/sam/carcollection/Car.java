package at.htlle.sam.carcollection;
import java.util.Objects;
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
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o != null && o.getClass() != this.getClass()){
            return false;
        }
        Car car = (Car) o;
        return this.marke.equals(car.marke) && this.modell.equals(car.modell);
    }
    @Override
    public int hashCode(){
        return Objects.hash(marke, modell);
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
