package streams;

import java.util.ArrayList;
import java.util.List;

public class SupplierDemo {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1111);
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(11);
        list.add(11);
        list.add(11);
        list.add(11);
        list.add(11);
        list.add(11);
        list.add(11);
        list.add(11);
        list.add(4);

   System.out.println(   list.stream().parallel().collect(()->new ArrayList<>(),
         (l,i)-> {
        System.out.println(l.hashCode()+" length :"+l.size()+" item :"+i);
            l.add(i);
        
        }, (l1,l2)->l1.addAll(l2)));

    }
}
