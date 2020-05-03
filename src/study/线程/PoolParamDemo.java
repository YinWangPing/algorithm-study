package study.线程;

import java.util.concurrent.*;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 20:02
 */
class Task implements Runnable{
    private int num;
    public Task(int num) {
        this.num = num;
    }
    @Override
    public void run() {
        System.out.println("The Task"+num+"is running");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Task"+num+"finished");
    }
}

public class PoolParamDemo {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5,
                10,200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5));
        for (int i = 0; i <20 ; i++) {
            myTask task=new myTask(i);
            threadPoolExecutor.execute(task);
            System.out.println("The thread number in Thread Pool is:"+threadPoolExecutor.getPoolSize()
            +",the queue length is:"+threadPoolExecutor.getQueue().size()
                    +",finished thread num is:"+threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }
}
