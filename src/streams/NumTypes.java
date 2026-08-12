package streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumTypes {
    public static void main(String[] args) throws Exception{
        IntStream.rangeClosed(0, 6).forEach(System.out::println);
        String s="sasasarhwiandjn0";
        s.chars().mapToObj(i->(char)i).forEach(System.out::print);
        FileReader fr=new FileReader("");
        BufferedReader bufferedReader=new BufferedReader(fr);
    Stream<String> stream=    bufferedReader.lines();
     Stream<String> stream2=   s.lines();
        Path path=Path.of("");
      Stream<String> stream3=  Files.lines(path);

      
    }
}
