import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 14:37
 */

public class LockReEnter implements Runnable{
    ReentrantLock lock=new ReentrantLock();
    public void get(){
        lock.lock();
        System.out.println(Thread.currentThread().getId()+"\t");
        set();
        lock.unlock();
    }
    public void set(){
        lock.lock();
        System.out.println(Thread.currentThread().getId()+"\t");
        lock.unlock();
    }
    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        LockReEnter lockReEnter=new LockReEnter();
        new Thread(lockReEnter).start();
        new Thread(lockReEnter).start();
    }
}
