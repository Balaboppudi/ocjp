import java.util.concurrent.Executor;

public class MySimpleExecutor {
    public static void main(String[] args) {
        Executor executor=SimpleExecutor.getInstance();
        executor.execute(()->System.out.println("This is my simple executor"));
    }
}

class SimpleExecutor implements Executor{
@Override
public void execute(Runnable command) {
    new Thread(command).start();
}
public static SimpleExecutor getInstance(){
return new SimpleExecutor();
}
}