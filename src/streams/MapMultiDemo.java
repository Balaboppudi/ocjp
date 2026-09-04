package streams;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MapMultiDemo{
public static void main(String[] args) {
    List<String> list=List.of("1","3","assa");

    list.stream().mapMulti((i,consimer)->{
        if(i.length()>2){
        consimer.accept(i);

        }
    }).forEach(System.out::println);;
    List<List<Integer>> list2=List.of(List.of(1,2,3),List.of(4,5,6));

    List.of(List.of(1,2,3),List.of(4,5,6)).stream().mapMulti((l,cosu)->{
        l.forEach(k->{
            if(k!=6){
            cosu.accept(k);    
            }
            });
    }).forEach(System.out::println);;
  List<String> ds=  Stream.of(CD.cdList,CD.cdList2).mapMulti((List<CD> m, Consumer<String> con)->{
 for (CD cd : m) {
    con.accept(cd.title());
  }
    }).distinct().toList();

long s=    Stream.of(CD.cdList,CD.cdList2).mapMultiToInt((l, con)->{
        l.forEach((i)->con.accept(i.title().length()));
    }).sum();
    System.out.println(s+" is the sum..");
}
}