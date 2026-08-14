package streams;

import java.util.List;
import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<CD> list1=CD.cdList;
        List<CD> list2=CD.cdList2;


        Stream.of(list1,list2).distinct().toList().forEach(it->System.out.println(it));
        Stream.of(list1,list2).distinct().toList().forEach(it->System.out.println(it));
        Stream.of(list1,list2).map(List::stream). distinct().toList().forEach(it->System.out.println(it));
        Stream.of(list1,list2).flatMap(List::stream). distinct().toList().forEach(it->System.out.println(it));
        
        // s<L<c>>->List<CD> ->l<l<cd>>
        //s<l<c>> -> s<s<l<c>>> -> s<s<l<c>>> -> L<s<c>>
        
    }
}
