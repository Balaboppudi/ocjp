import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapComparisonExample {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        int iterations = 1000;

        // 1. HashMap Demo (Not Thread-Safe)
        Map<String, Integer> unsafeMap = new HashMap<>();
        runMultithreadedUpdate(unsafeMap, threadCount, iterations);
        // Often outputs less than 5000, or crashes with a ConcurrentModificationException
        System.out.println("HashMap final size: " + unsafeMap.size()); 

        // 2. ConcurrentHashMap Demo (Thread-Safe)
        Map<String, Integer> safeMap = new ConcurrentHashMap<>();
        runMultithreadedUpdate(safeMap, threadCount, iterations);
        // Guaranteed to output exactly 5000
        System.out.println("ConcurrentHashMap final size: " + safeMap.size()); 
    }

    private static void runMultithreadedUpdate(Map<String, Integer> map, int threads, int iterations) 
            throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            final int threadId = i;
            executor.execute(() -> {
                for (int j = 0; j < iterations; j++) {
                    // Unique key for every single entry across all threads
                    map.put("Thread-" + threadId + "-Key-" + j, j);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
