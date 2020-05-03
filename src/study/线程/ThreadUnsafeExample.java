package study.线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/3 12:16
 */

public class ThreadUnsafeExample {
    private int cnt=0;
    public void add(){
        cnt++;
    }
    public int get(){
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize=1000;
        ThreadUnsafeExample example=new ThreadUnsafeExample();
        CountDownLatch countDownlatch=new CountDownLatch(threadSize);
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i <threadSize ; i++) {
            executorService.execute(()->{
                example.add();
                countDownlatch.countDown();
            });
        }
        countDownlatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
