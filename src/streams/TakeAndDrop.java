package streams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TakeAndDrop {
    public static void main(String[] args) {
        Stream.of(3,2,1,7,8).takeWhile(i->i!=9).forEach(System.out::println);
        Stream.of(3,2,1,7,8,99,1,2,3).dropWhile(i->i<9).forEach(System.out::println);
        Stream.of(3,2,1,7,8,99,1,2,3).dropWhile(i->i<9).forEach(System.out::println);
    Stream.of("a","b").mapToInt(s->s.length()).forEach(System.out::println);
    IntStream.of(1,2,3).map(i->1);
    IntStream.range(0, 0);
       System.out.println( IntStream.generate(()-> (int) (6.0 * Math.random()) + 1).limit(1000)
        .map(k1->6==0?1:0).sum());

    }
}
