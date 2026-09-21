package at.htlle.threading.start;


// TODO: Task 2 - Sequential vs. Parallel
// Calculate the sum from 1 to 10_000_000.
// 1) Implement a sequential version and measure the time using System.currentTimeMillis().
// 2) Split the range into 4 parts and calculate in parallel using 4 threads.
// 3) Measure and compare the times and verify the results are equal.
// Hints (optional): consider using long for sums.

public class SumCalculator {

    public static void main(String[] args) throws InterruptedException {

        // 1. SEQUENZIELL
        long start = System.currentTimeMillis();

        long sequentialSum = 0;

        for (long i = 1; i <= 10_000_000; i++) {
            sequentialSum += i;
        }

        long end = System.currentTimeMillis();

        System.out.println("Sequential sum: " + sequentialSum);
        System.out.println("Sequential time: " + (end - start) + " ms");


        // 2. PARALLEL MIT 4 THREADS
        long[] sums = new long[4];

        Thread a = new Thread(() -> {
            for (long i = 1; i <= 2_500_000; i++) {
                sums[0] += i;
            }
        });

        Thread b = new Thread(() -> {
            for (long i = 2_500_001; i <= 5_000_000; i++) {
                sums[1] += i;
            }
        });

        Thread c = new Thread(() -> {
            for (long i = 5_000_001; i <= 7_500_000; i++) {
                sums[2] += i;
            }
        });

        Thread d = new Thread(() -> {
            for (long i = 7_500_001; i <= 10_000_000; i++) {
                sums[3] += i;
            }
        });

        start = System.currentTimeMillis();

        a.start();
        b.start();
        c.start();
        d.start();

        a.join();
        b.join();
        c.join();
        d.join();

        long parallelSum = sums[0] + sums[1] + sums[2] + sums[3];

        end = System.currentTimeMillis();

        System.out.println("Parallel sum: " + parallelSum);
        System.out.println("Parallel time: " + (end - start) + " ms");


        System.out.println("Results equal: " + (sequentialSum == parallelSum));
    }
}