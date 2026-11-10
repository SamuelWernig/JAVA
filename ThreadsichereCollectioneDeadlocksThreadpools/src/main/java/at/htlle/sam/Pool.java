package at.htlle.sam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<String> results = Collections.synchronizedList(new ArrayList<>());

        for (int i = 1; i <= 10; i++) {
            int taskNumber = i;
            executor.execute(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " bearbeitet Aufgabe " + taskNumber);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                results.add("Aufgabe " + taskNumber + " erledigt");
            });
        }

        executor.shutdown();
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }

        System.out.println();
        System.out.println(results);
    }
}