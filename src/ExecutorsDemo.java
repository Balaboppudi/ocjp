import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
      ExecutorService executor = Executors.newFixedThreadPool(10);
      ExecutorService executor1 = Executors.newCachedThreadPool();
    Future<Integer> future=  executor.submit(()->{
        TimeUnit.SECONDS.sleep(6);
        System.out.println("Helooooooooo");
        return 1;
    });
    // future.can
    //  Object o= future.get();
     System.out.println(1+" is from Future Object");
     executor.shutdown();
    executor.awaitTermination(1, TimeUnit.SECONDS);
      System.out.println("Main exit");
    }
}
