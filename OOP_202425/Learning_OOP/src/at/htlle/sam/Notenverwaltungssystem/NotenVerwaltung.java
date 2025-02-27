package at.htlle.sam.Notenverwaltungssystem;

public class NotenVerwaltung {
    private double[] noten;

    public NotenVerwaltung(double[] noten) {
        this.noten = noten;

    }
    public double berechneDurchschnitt(){
        double x = 0;
        double count = 0;
        for (int i = 0; i < this.noten.length; i++) {
            if ( this.noten[i] != 0){}
                x += this.noten[i];
                count++;
        }
        x = (x/count)*1000;
        int y = (int) x;
        x = ((double) y) /1000;
        return x;
    }
    public double findMaxNote(){
        double max = 0;
        for( int i = 0; i<this.noten.length; i++){
            if(this.noten[i] > max){
                max = this.noten[i];
            }
        }
        return max;
    }
    public double findMinNote(){
        double min = this.noten[0];
        for( int i = 1; i<this.noten.length; i++){
            if (this.noten[i] < min){
                min = this.noten[i];
            }
        }
        return min;
    }
}
