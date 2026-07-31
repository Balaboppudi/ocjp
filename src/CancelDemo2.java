import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CancelDemo2 {
    public static void main(String[] args) {
        Callable<Integer> runnable=()->{
            try {
                System.out.println("started");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return 100;
        };
    ScheduledExecutorService executorService= Executors.newScheduledThreadPool(2);

      Future<Integer> future= executorService.submit(runnable);
      try {
        //   future.get(15,TimeUnit.SECONDS);
          executorService.schedule(()->future.cancel(true), 0, TimeUnit.SECONDS);
        executorService.shutdown();
    } catch (Exception e) {
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
