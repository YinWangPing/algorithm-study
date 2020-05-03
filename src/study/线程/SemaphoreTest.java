package study.线程;

import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/13 11:08
 */
class SemaphoreThread extends Thread{
    private Semaphore semaphore;
    private String threadName;

    public SemaphoreThread(Semaphore semaphore, String threadName) {
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        if(semaphore.availablePermits()>0){
            System.out.println(threadName+"start,apply the connection");
        }else{
            System.out.println(threadName+"start,no available connection");
        }
        try{
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println(threadName+"get connection.");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class SemaphoreTest {
    public static void main(String[] args) {
        //指定初始化可用资源的数目以及是否是公平锁
        Semaphore semaphore=new Semaphore(3,false);
        for (int i = 0; i <5 ; i++) {
            new SemaphoreThread(semaphore,Integer.valueOf(i).toString()).start();
        }
    }
}
