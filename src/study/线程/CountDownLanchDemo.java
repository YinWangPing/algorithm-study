package study.线程;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/24 10:36
 */
class Task1 implements Callable<String>{
    private CountDownLatch latch;
    private String taskName;

    public Task1(CountDownLatch latch, String taskName) {
        this.latch = latch;
        this.taskName = taskName;
    }

    @Override
    public String call() throws Exception {
        try {
//            省略从三个URL获取结果的步骤，直接用URL模拟
            return "API NAME:"+ taskName;
        }finally {
            latch.countDown();
            System.out.println(taskName+"\t"+latch.getCount());
        }
    }
}
public class CountDownLanchDemo {
    /**
     *用来控制一个或者多个线程等待多个线程。
     *维护了一个计数器 cnt，每次调用 countDown() 方法会让计数器的值减 1，
     *减到 0 的时候，那些因为调用 await() 方法而在等待的线程就会被唤醒。
     */
    public static void main(String[] args) {
        System.out.println(1/0);
        ExecutorService executorService= Executors.newCachedThreadPool();
        List<String> resultList=new ArrayList<>();
        CountDownLatch latch=new CountDownLatch(3);
        Future<String> future1=executorService.submit(new Task1(latch,"TASK1"));
        Future<String> future2=executorService.submit(new Task1(latch,"TASK2"));
        Future<String> future3=executorService.submit(new Task1(latch,"TASK3"));
        try{
            //设置超时时间
            latch.await(4000,TimeUnit.MILLISECONDS);
            System.out.println("Count Down All Finished");
            resultList.add(future1.get());
            resultList.add(future2.get());
            resultList.add(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        Iterator<String>iterator=resultList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
