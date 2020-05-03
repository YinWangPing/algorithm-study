package study.线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/3 12:23
 */

public class ThreadUnsafeExample1 {
    private int cnt=0;
    public void add() {
        cnt++;
//        System.out.println(Thread.currentThread().getName()+"\t"+cnt);
    }
    public int get(){
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        CountDownLatch countDownLatch=new CountDownLatch(1000);
        ThreadUnsafeExample1 example1=new ThreadUnsafeExample1();
        for (int i = 0; i <1000 ; i++) {
            executorService.execute(()->{
                example1.add();
                countDownLatch.countDown();
            });
        }
        executorService.shutdown();
        countDownLatch.await();
        System.out.println(example1.get());
    }
}
