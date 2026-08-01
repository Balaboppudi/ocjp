import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinDemo {
    public static void main(String[] args) {
        
        int[] values=IntStream.range(1, 20).toArray();
    
       var forkJoinPool= new ForkJoinPool();
      Integer result= forkJoinPool.invoke(new FilterTask(0, values.length, values));
       System.out.println(result);

    }
}
class FilterTask extends RecursiveTask<Integer>{
    
    int LIMIT=2;
    int start =0;
    int end ;
    int[] values;
    FilterTask(int start, int end, int[] values){
        this.start = start;
        this.end = end;
        this.values = values;
    }
    @Override
    protected Integer compute() {
      int count=0;
        if(end-start <=LIMIT){
            for (int i = start; i < end; i++) {
              if(values[i]%7==0){
                System.out.println(values[i]);
                count++;
              }  
            }
            return count;
      }else{
            int mid = (end+start)/2;
            FilterTask f1=new FilterTask(start, mid, values);
            FilterTask f2=new FilterTask(mid, end, values);
            ForkJoinTask.invokeAll(f1,f2);
            return f1.join()+f2.join();
            
      }
    
    }
    

}