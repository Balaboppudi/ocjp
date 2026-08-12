package streams;

import java.util.IntSummaryStatistics;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsBasics {
    public static void main(String[] args) {
        BaseStream<Integer, IntStream> bs = IntStream.of(1, 1);
        try (IntStream bs2 = IntStream.of(1, 1)) {
            // bs2.forEach(System.out::println);
        }
        IntStream bs2 = IntStream.of(1, 1);
        IntSummaryStatistics intSummaryStatistics = bs2.summaryStatistics();
        intSummaryStatistics.getSum();

       Stream<Integer> supplier= Stream.generate(()->2).limit(10);
       supplier.parallel().forEach(it->{
        
        System.out.println(it+"  "+Thread.currentThread().getName());
    });

    }
}
