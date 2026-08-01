public class NonVolatile {
  // NON-VOLATILE: Threads may cache this value locally
    private static volatile boolean keepRunning = true; 

    public static void main(String[] args) throws InterruptedException {
        // Thread 1: The background worker
        Thread worker = new Thread(() -> {
            while (keepRunning) {
                // System.out.println("Running...!");
                // The CPU may optimize this by caching keepRunning = true
            }
            System.out.println("Worker thread stopped cleanly.");
        });
        worker.start();

        // Let the worker run for 1 second
        Thread.sleep(1000); 

        // Thread 2: Main thread updates the shared variable
        System.out.println("Main thread is setting keepRunning to false...");
        keepRunning = false; 
        
        System.out.println("Main thread finished.");
    }
}