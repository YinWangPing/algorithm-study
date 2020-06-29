package study.AQS;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("五个线程全部到达Barrier状态");
            }
        });
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i <9 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName()+"\t"+"run");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.execute(new Runnable() {
            @Override
            public void run() {
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                System.out.println(Thread.currentThread().getName()+"\t"+"run");
                try {
                    cyclicBarrier.reset();
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("end");
    }
}
