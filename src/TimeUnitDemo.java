import java.util.concurrent.TimeUnit;

class TimeUnitDemo{
    public static void main(String[] args) throws InterruptedException {
      MyThread m=new MyThread();
        Thread t1= new Thread(()->m.test());
      t1.setDaemon(true);
       t1.start();
        Thread t2= new Thread(()->m.test());;
    t2.setDaemon(true);
       t2.start();
       Thread.currentThread().join(10000);
       System.out.println("Main exited");
    }
}


 class MyThread {

    public void test(){
        System.out.println(Thread.currentThread().getName()+" started...");
        System.out.println(Thread.currentThread().getName()+" going to sleep...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName()+" after sleep...");
        System.out.println(Thread.currentThread().getName()+" completed...");
    }
    
}