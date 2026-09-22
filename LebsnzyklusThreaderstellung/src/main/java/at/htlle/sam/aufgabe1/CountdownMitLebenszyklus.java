package at.htlle.sam.aufgabe1;

public class CountdownMitLebenszyklus {

    public static void countdown(){
        for (int i = 10; i >= 0; i--){
            System.out.println("Thread-" + Thread.currentThread().getName() + ": " + i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->
                countdown(),"Countdown-A");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countdown();
        }, "Countdown-B");

        System.out.println(t1.getState());
        System.out.println(t2.getState());

        t1.start();
        t2.start();

        System.out.println(t1.getState());
        System.out.println(t2.getState());

        t1.join();
        t2.join();

        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }

}
