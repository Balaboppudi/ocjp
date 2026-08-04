import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentCollectionsDemo3 {
public static void main(String[] args) throws InterruptedException,Exception {
    ConcurrentSkipListSet<Integer> set =new ConcurrentSkipListSet<>();
    new Random()
    .ints(10, 100, 1000)
    .forEach(i->set.add(i));
    System.out.println(set);
    Runnable sum=()->{
    
        while (true) {
              int sum1 =0;
        for (Integer integer : set) {
            sum1+=sum1+integer;
        }
        System.out.println("Sum is "+sum1);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
          System.out.println(Thread.currentThread().getName() + ": " + e);
      Thread.currentThread().interrupt();   
        }
         if (Thread.interrupted()) break; 
      }  
    };

    Runnable remove =()->{
         while (true) {
       Integer el= set.pollLast();
        if (el == null) continue;
       System.out.println("Removed .."+el);
       try {
        TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
       System.out.println(Thread.currentThread().getName() + ": " + e);
      Thread.currentThread().interrupt();   
    }
     if (Thread.interrupted()) break;  
} 
    };

   ExecutorService executorService= Executors.newFixedThreadPool(2);

   executorService.submit(sum);
   executorService.submit(remove);
  TimeUnit.SECONDS.sleep(5);
                                 
  executorService.shutdownNow();  
}
    
}