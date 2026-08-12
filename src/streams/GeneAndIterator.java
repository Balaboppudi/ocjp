 package streams;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeneAndIterator {
public static void main(String[] args) {
    Random random=new Random();
    Stream.generate(()->random.nextInt()).limit(10).forEach(System.out::println);
Stream.iterate(3,(op)->op+2).limit(10).forEach(System.out::println);
Set<Integer> set1=Set.of(1,2,5,3,4);
System.out.println(set1.stream().isParallel());
System.out.println(Arrays.stream(new int[]{1,2,3}).count());
// Stream.of(new int[]{1,2,3}).flatMap((it)->Arrays.stream(it).ma(it1->Stream.of(it1))).forEach(it->i);



}
    
}