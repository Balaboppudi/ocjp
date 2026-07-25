public class Starvation {
public static void main(String[] args) {
    Hole hole =new Hole();
    for (int i = 0; i < 5; i++) {
        System.out.println("hello");
        new Thread(()->hole.dig()).start();
    }
}    
}

 class Hole {

    public synchronized void dig(){
        while (true) {
            System.out.println(Thread.currentThread().getName()+" digging hole...");
            try {
                // wait(1000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }
}
