import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownDemo{
public static void main(String[] args)throws Exception {
   CountDownLatch startLatch=new CountDownLatch(1);
   CountDownLatch finisLatch=new CountDownLatch(3);

   ExecutorService executorService=Executors.newFixedThreadPool(3);
   for (int i = 0; i < 3; i++) {
    executorService.submit(new Task(startLatch, finisLatch));
   }
   startLatch.countDown();
   finisLatch.await();
   System.out.println("All are done...");
    TimeUnit.SECONDS.sleep(10);
    executorService.shutdown();
}
}

class Task implements Runnable{
    CountDownLatch startLatch;
    CountDownLatch finisLatch;
    

    public Task(CountDownLatch startLatch, CountDownLatch finisLatch) {
        this.startLatch = startLatch;
        this.finisLatch = finisLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"..is waiting.");
            startLatch.await();
            System.out.println(Thread.currentThread().getName()+"..is completed.");
            finisLatch.countDown();


        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}