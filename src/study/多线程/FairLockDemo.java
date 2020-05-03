import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 14:46
 */

public class FairLockDemo {
    /**
     * true 表示ReenTrantLock的公平锁
     * 公平锁谁先(创建)启动，谁就获得锁
     * false 非公平锁
     * 公平锁先创建的不一定先获得锁(如下所示，0先启动而2先获取锁)
     * Thread-0启动  Thread-2启动  Thread-1启动  Thread-2获得了锁  Thread-1获得了锁  Thread-3启动  Thread-0获得了锁
     * Thread-4启动  Thread-4获得了锁  Thread-3获得了锁  Thread-6启动  Thread-6获得了锁
     * Thread-5启动  Thread-5获得了锁  Thread-7启动  Thread-7获得了锁  Thread-9启动
     * Thread-9获得了锁  Thread-8启动  Thread-8获得了锁
     */
    private ReentrantLock lock = new ReentrantLock(false);

    public void testFair() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairLockDemo fairlock = new FairLockDemo();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            fairlock.testFair();
        };
        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}
