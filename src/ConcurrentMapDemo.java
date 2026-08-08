import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConcurrentMapDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, Long> concurrentMap = new ConcurrentHashMap<>();
        // HashMap<Integer, Long> concurrentMap = new HashMap<>();

        Runnable diceResultsReader = () -> {
            String threadName = Thread.currentThread().getName();
            while (true) {
                // (1)
                Set<Integer> keySetView = concurrentMap.keySet();
                String output = "";
                for (Integer key : keySetView) {
                    Long value = concurrentMap.get(key);
                    output += " " + "<" + key + "," + value + ">";
                }
                 
                System.out.println(threadName + ": {" + output + " }");
                 if (Thread.interrupted()) break;
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                }
              
            }
        };

        Runnable remover = () -> {
            String threadName = Thread.currentThread().getName();

            while (true) {
                // try {
                //     TimeUnit.MILLISECONDS.sleep(500);
                // } catch (InterruptedException e) {
                //     // TODO Auto-generated catch block
                //     // e.printStackTrace();
                // }
                if (Thread.interrupted()) break;
                Integer integer = new Random().nextInt(1, 7);
                Long key = concurrentMap.remove(integer);
                if (key == null)
                    continue;
                concurrentMap.remove(integer);
                 String removedEntry = threadName + ": removed "
     + "<" + integer + "," + key + ">";
  System.out.println(removedEntry);
            }
        };

           Runnable diceResultRemover = () -> {                    
String threadName = Thread.currentThread().getName();
while (true) {
//   ConcUtil.snooze(500, TimeUnit.MILLISECONDS);
  if (Thread.interrupted()) break;
  Integer key = ThreadLocalRandom.current().nextInt(1, 7);  // [1, 6]
  Long value = concurrentMap.remove(key);
  if (value == null) continue;
  String removedEntry = threadName + ": removed "
     + "<" + key + "," + value + ">";
  System.out.println(removedEntry);
}
           };
  

        new Random()
                .ints(20, 1, 7)
                .boxed()
                .parallel()
                .collect(Collectors.groupingByConcurrent(Function.identity(), () -> concurrentMap,
                        Collectors.counting()));
        System.out.println(concurrentMap);


        ExecutorService exs = Executors.newFixedThreadPool(3);
try {
//   exs.submit(diceResultsReader);                                     
  exs.submit(remover);
  exs.submit(remover);
  TimeUnit.SECONDS.sleep(3);
} finally {
  exs.shutdownNow();                                                 
}
}
    
   
}
