import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomDemo {
    public static void main(String[] args) {
        int i=ThreadLocalRandom.current().nextInt(1, 7);
        System.out.println(i);
    }
}
