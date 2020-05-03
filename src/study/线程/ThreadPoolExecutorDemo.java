package study.线程;

import java.util.concurrent.*;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/21 15:57
 */

class myTask implements Runnable {
    private int num;

    public myTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("The Task" + Thread.currentThread().getName()+"\t"+num+"\t"+"is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task" +"\t"+num +"\t"+"finished");
    }
}
/**
 *拒绝策略：新建一个线程进行执行
 */
class MyRejection implements RejectedExecutionHandler {
    MyRejection() {
        super();
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            final Thread t = new Thread(r, "Temporary task executor");
            t.start();
        } catch (Throwable e) {
            throw new RejectedExecutionException(
                    "Failed to start a new thread", e);

        }
    }
}
class AbortPolicyWithReport extends ThreadPoolExecutor.AbortPolicy {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        String msg = String.format("Thread pool is EXHAUSTED!" +
                        " Thread Name: %s, Pool Size: %d (active: %d, core: %d, max: %d, largest: %d), Task: %d (completed: %d)," +
                        " Executor status:(isShutdown:%s, isTerminated:%s, isTerminating:%s)",
                Thread.currentThread().getName(), e.getPoolSize(), e.getActiveCount(), e.getCorePoolSize(), e.getMaximumPoolSize(), e.getLargestPoolSize(),
                e.getTaskCount(), e.getCompletedTaskCount(), e.isShutdown(), e.isTerminated(), e.isTerminating());
        throw new RejectedExecutionException(msg);
    }

}
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 11; i++) {
            myTask task = new myTask(i);
            threadPoolExecutor.execute(task);
            System.out.println("The thread number in Thread Pool is:" + threadPoolExecutor.getPoolSize()
                    + ",the queue length is:" + threadPoolExecutor.getQueue().size()
                    + ",finished thread num is:" + threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }
}
