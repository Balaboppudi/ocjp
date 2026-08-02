import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantDemo {
public static void main(String[] args) throws Exception {
    Counter counter=new Counter();
    for (int i = 0; i < 50; i++) {
        new Thread(()-> counter.inc()).start();
    }

    // IntStream.rangeClosed(1, 1000).forEach(i->counter.in());
    TimeUnit.SECONDS.sleep(10);
    System.out.println(counter.i);
}
}

class Counter {
    int i = 1;
    ReentrantLock lock = new ReentrantLock();

    public Integer getValue() {
        try {
            lock.lock();
            System.out.println(lock.getHoldCount()+"...No of locks");
            return i;
        } finally {
            lock.unlock();
        }

    }
    public void inc(){
        try{
            lock.lock();
            getValue();
            i++;
        }finally{
            lock.unlock();
        }
    }

}