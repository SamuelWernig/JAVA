package at.htlle.sam.aufgabe2;

public class ComputeTask implements Runnable {

    private long sum;

    @Override
    public void run() {

        for (long i=0;i<100_000_000;i++){
            sum+=i;
        }
    }


    public long getSum() {
        return sum;
    }
}
