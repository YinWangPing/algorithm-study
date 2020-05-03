package study.线程;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/2 15:58
 */
class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName()+"**";
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        while (!Thread.interrupted()) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(Thread.currentThread().getName() + "\t" + sdf.format(new Date()));
        }
        System.out.println("thread end");
    }
}
public class Mythread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HashMap<String,String> map=new HashMap<>();
        map.put(null,"adc");
        System.out.println(map.get(null));
        System.out.println("-------------------------------------");
        FutureTask<Integer> futureTask=new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res=0;
                for (int i = 0; i <50 ; i++) {
                    Thread.sleep(10);
                    res+=i;
                }
                return res;
            }
        });
        new Thread(futureTask,"Thread-future").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"running");
            }
        },"OtherThread").start();
        System.out.println(futureTask.get());
//        Thread mainthread=Thread.currentThread();
//        Thread thread=new Thread(()->{
//            for (int i = 0; i <100 ; i++) {
//                if(i==3){
//                    try {
//                        System.out.println("----------------------");
//                        mainthread.join();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("线程名+" + Thread.currentThread().getName()+ "***数字为"+i);
//            }
//        });
//        thread.start();
//        for (int i = 0; i <10 ; i++) {
//            Thread.sleep(100);
//            System.out.println("main方法名+" + "***数字为"+i);
//        }
//        Thread thread=new Thread(()->{
//            for (int i = 0; i <20 ; i++) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("线程名+" + Thread.currentThread().getName()+ "***数字为"+i);
//            }
//        });
//        thread.start();
//        for (int i = 0; i <10 ; i++) {
//            Thread.sleep(10);
//            System.out.println("main方法名+" + "***数字为"+i);
//        }
//        MyRunnable myRunnable=new MyRunnable();
//        Thread thread=new Thread(myRunnable);
//        thread.start();
////        thread.sleep(200);
//        thread.interrupt();
//        System.out.println("main run");
//        Thread thread=new Thread(()->{
//            System.out.println("开始执行");
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                System.out.println("中断执行");
//            }
//            System.out.println("执行完毕");
//        });
//        thread.start();
//        Thread.sleep(100);
//        if(!thread.isInterrupted()){//线程未被中断返回法拉瑟
//            thread.interrupt();
//            System.out.println("中断");
//        }

//        MyCallable mt = new MyCallable();
//        FutureTask<String> ft=new FutureTask<String>(mt);
//        Thread thread=new Thread(ft);
//        thread.start();
//        System.out.println(ft.get());
//        ExecutorService executorService= Executors.newSingleThreadExecutor();
//        for (int i = 0; i <5 ; i++) {
//            executorService.execute(new MyRunnable());
//        }
//        executorService.shutdown();
    }
}
