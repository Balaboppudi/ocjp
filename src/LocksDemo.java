import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class LocksDemo {
    public static void main(String[] args) throws Exception{
        Lock lock = new ReentrantLock(true);
        lock.lock();
        lock.unlock();
        ReadLock readLock = new ReentrantReadWriteLock().readLock();
        WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
        readWriteLock.readLock();
        readWriteLock.writeLock();
        readLock.lock();
        writeLock.lock();

        lock.tryLock();
        lock.tryLock(1, TimeUnit.SECONDS);
        readLock.tryLock();
        writeLock.tryLock();
        lock.lockInterruptibly();

    }
}
