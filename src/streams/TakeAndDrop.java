package streams;

import java.util.stream.Stream;

public class TakeAndDrop {
    public static void main(String[] args) {
        Stream.of(3,2,1,7,8).takeWhile(i->i!=9).forEach(System.out::println);
        Stream.of(3,2,1,7,8,99,1,2,3).dropWhile(i->i<9).forEach(System.out::println);
    }
}
