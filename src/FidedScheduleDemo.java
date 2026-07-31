import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FidedScheduleDemo {
    public static void main(String[] args) {
      ScheduledExecutorService executorService=  Executors.newScheduledThreadPool(4);
    
      Runnable r=()->{
        printTimestamp("I am on it");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printTimestamp("Finished");

      };

    //   executorService.scheduleWithFixedDelay(
    //     r, 1, 3, TimeUnit.SECONDS);
     
    // Overrun Caveat: If a task takes longer than the period, the next execution will wait until the current one finishes. “If a task takes longer to execute than the period between its scheduled executions, the next execution will start after the current execution finishes.”, according to StackOverflow. They will not run concurrently on multiple threads. Instead, subsequent executions will trigger in rapid succession to "catch up" to the scheduled time
       executorService.scheduleAtFixedRate(
        r, 1, 1, TimeUnit.SECONDS);
     
  try {
    TimeUnit.SECONDS.sleep(155);
} catch (InterruptedException e) {
    e.printStackTrace();
}                                        

   executorService.shutdown();  
    }

    private static void printTimestamp(String msg) {                       
String threadName = Thread.currentThread().getName();
 // (1)
 // (2)
String ts = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss:nn"));
System.out.println(threadName + ": " + ts + msg);
  }
}
