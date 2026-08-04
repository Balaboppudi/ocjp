import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentCollectionsDemo2 {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> concurrentLinkedDeque=new ConcurrentLinkedQueue<>();
        concurrentLinkedDeque.add(1);
        concurrentLinkedDeque.add(3);
        concurrentLinkedDeque.add(5);
        concurrentLinkedDeque.add(4);
        System.out.println(concurrentLinkedDeque);
        concurrentLinkedDeque.add(12);
        System.out.println(concurrentLinkedDeque);
        concurrentLinkedDeque.poll();
        System.out.println(concurrentLinkedDeque);

        

    }
}