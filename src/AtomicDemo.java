import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicDemo
 */
public class AtomicDemo {
       static AtomicInteger atomicInteger=new AtomicInteger(10);

        public void inc(){
            System.out.println(Thread.currentThread().getName()+" incremented");
           atomicInteger.incrementAndGet();
        }
    public static void main(String[] args) throws Exception{
        AtomicDemo atomicDemo=new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(()->atomicDemo.inc()).start();;
        }
        TimeUnit.SECONDS.sleep(10);
System.out.println(atomicInteger.get());
    }
}