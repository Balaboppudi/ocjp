import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicDemo {
    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(3, ()->{
            System.out.println(Thread.currentThread().getName()+" is Barier breaker...");
        });

        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting..");
                barrier.await();

System.out.println(Thread.currentThread().getName() + " is completed..");
                
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }

        TimeUnit.SECONDS.sleep(4);
    }

}