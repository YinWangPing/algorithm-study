package study.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    private void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void after() {
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {

        System.out.println(0b11100000000000000000000000000000);
        System.out.println(0<<29);
        ReentrantLockDemo reentrantLockDemo=new ReentrantLockDemo();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                reentrantLockDemo.after();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                reentrantLockDemo.before();
//            }
//        }).start();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(()->{reentrantLockDemo.after();});
        executorService.execute(()->{reentrantLockDemo.before();});
    }
}
