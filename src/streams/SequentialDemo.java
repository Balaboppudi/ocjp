package streams;

import java.util.OptionalInt;
import java.util.function.IntToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequentialDemo {

    public static void main(String[] args) {
        Stream<Integer> s=Stream.of(1,2,3);
        s.forEach(System.out::print);
        System.out.println(s.sequential());
        IntToDoubleFunction doubleFunction=(i)->(double)i;
     DoubleStream doubleStream=   getDoubleStream(doubleFunction);
        IntStream.of(1,2).mapToDouble(i->1.1d+i).sum();
       int i= OptionalInt.of(12).getAsInt();
       int i1=Integer.valueOf(1).intValue();
    }

    private static DoubleStream getDoubleStream(IntToDoubleFunction doubleFunction) {

      return DoubleStream.of(doubleFunction.applyAsDouble(10));
    }
}