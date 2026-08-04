import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentCollectionsDemo {

   public static void main(String[] args) {
    ConcurrentSkipListSet<Integer> set =new ConcurrentSkipListSet<Integer>();
    Queue<Integer> queue=new ConcurrentLinkedDeque<>();
    Deque<Integer> deque=new ConcurrentLinkedDeque<>();
    set.add(1);
    set.add(1);
    set.add(4);
    set.add(5);
    set.add(6);
    set.add(7);
    set.add(0);
        set.add(3);

    Iterator<Integer> iterator= set.iterator();
   iterator.hasNext();
   System.out.println(iterator.next());
    // iterator.remove();
    System.out.println(set.pollFirst());
    System.out.println(set.pollLast());
    set.pollLast();



    System.out.println(set);

} 
}