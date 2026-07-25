public class App {
    public static void main(String[] args) throws Exception {
        Customer customer=new Customer();
        Shipper shipper=new Shipper();
        new Thread(()->customer.makePaymet(shipper)).start();
        new Thread(()->shipper.ship(customer)).start();
        
    }
}
class Customer{
    private boolean isPaymentDone = false;
    public void makePaymet(Shipper shipper){
        while(!shipper.isShipped()){
System.out.println("Waiting for shippment");
try {
                    System.out.println(Thread.currentThread().getName()+"is sleeping");

    Thread.sleep(5000);
} catch (InterruptedException e) {
    e.printStackTrace();
}
        }
        isPaymentDone=true;
        System.out.println("Payment done");

    }
    public boolean isPaymentDone(){
        return isPaymentDone;
    }
}
/**
 * Shipper
 */
class Shipper {
private boolean isShipped = false;
    public void ship(Customer customer){
        while(!customer.isPaymentDone()){
            System.out.println("Waiting for Payment");

            try {
                System.out.println(Thread.currentThread().getName()+"is sleeping");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isShipped = true;
        System.out.println("Item shipped");

    }
public boolean isShipped(){
    return isShipped;
}
    
}