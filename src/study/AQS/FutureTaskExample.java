package study.AQS;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public interface FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask=new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum=0;
                Thread.sleep(10);
                for (int i = 0; i <100 ; i++) {
                    sum+=i;
                }
                return sum;
            }
        });
        new Thread(futureTask,"线程1").start();
        futureTask.cancel(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                futureTask.cancel(false);
                System.out.println(Thread.currentThread().getName()+"is Running");
            }
        },"线程2");
//        System.out.println(futureTask.get());
    }
}
