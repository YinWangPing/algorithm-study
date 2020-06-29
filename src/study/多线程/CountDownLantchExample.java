package study.多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLantchExample {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        CountDownLatch countDownLatch=new CountDownLatch(10);
        for (int i = 0; i <10 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run");
                    countDownLatch.countDown();
                }
            });
        }
        System.out.println("------------------------");
        for (int i = 0; i <3 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Other Thread running......");
                }
            });
        }
    }
}
