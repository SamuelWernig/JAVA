package at.htlle.threading.start;

// TODO: Task 3 - Named Threads
// Create 3 threads with custom names (e.g., "Alpha", "Beta", "Gamma").
// Each thread should print numbers 1..10, sleeping 200ms between prints.
// Use Thread.sleep(200) and handle InterruptedException properly.
// Observe that outputs interleave in an unpredictable order.

public class NamedThreads {
    public static void main(String[] args) throws InterruptedException {
        // TODO: Create and name threads
        // TODO: Loop 1..10 with Thread.sleep(200)
        Thread Alpha = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Alpha");
        Thread Beta = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Beta");
        Thread Gamma = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Gamma");

        Alpha.start();
        Beta.start();
        Gamma.start();

        Alpha.join();
        Beta.join();
        Gamma.join();

    }
}
