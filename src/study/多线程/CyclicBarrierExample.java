package study.多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("执行Barrier功能");
            }
        });
        for (int i = 0; i <5 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("before>>>>>>>>>>");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("After>>>>>>>>>>>");
                }
            });
        }
    }
}
