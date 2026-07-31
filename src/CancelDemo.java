import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CancelDemo {
    public static void main(String[] args) {
        Callable<Integer> runnable=()->{
            try {
                TimeUnit.MINUTES.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return 100;
        };
       ExecutorService executorService= Executors.newSingleThreadExecutor();

      Future<Integer> future= executorService.submit(runnable);

      try {
        future.get(15,TimeUnit.SECONDS);
        executorService.shutdown();
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
        // TODO Auto-generated catch block
        future.cancel(true);
        System.out.println(future.isCancelled());
        executorService.shutdownNow();
    }

    try {
        TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    
}
