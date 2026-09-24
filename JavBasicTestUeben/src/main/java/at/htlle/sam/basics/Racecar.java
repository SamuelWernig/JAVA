package at.htlle.sam.basics;

public class Racecar extends Auto {

    private int topSpeed;

    public Racecar(String marke, int kmStand, int topSpeed) {
        super(marke, kmStand);
        this.topSpeed = topSpeed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!super.equals(obj)){
            return false;
        }
        Racecar racecar = (Racecar) obj;
        return this.topSpeed == racecar.topSpeed;
    }


    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }
}
