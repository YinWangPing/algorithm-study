package study.线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {
    public synchronized void func1() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i + " ");
            }
    }
    public void func2() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i + " ");
            }
        }
    }


    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
    }
}

