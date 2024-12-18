package sam.oopintro.car;

public class ECar extends Car{

    private  double batteryCapacity;
    public ECar(String name,String color, double batteryCapacity) {
        super(name,color);
        this.batteryCapacity = batteryCapacity;
    }


    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    /*@Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        ECar car = (ECar)obj;
        if (this.getColor().equals(car.getColor()) && this.getName().equals(car.getName()) && this.getBatteryCapacity() == car.getBatteryCapacity()){
            return true;
        }
        else {
            return false;
        }
    }*/
    public boolean equals (Object obj) {
        if(!super.equals(obj)){
            return false;
        }
        else {
            ECar ecar = (ECar)obj;
            if(this.batteryCapacity == ecar.batteryCapacity) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
