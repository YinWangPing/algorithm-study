package study.线程;

import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/24 10:15
 */
/**
 * result:
 * 0start,apply the connection
 * 1start,apply the connection
 * 2start,apply the connection
 * 3start,no available connection
 * 4start,no available connection
 * 0get connection.
 * 1get connection.
 * 3get connection.
 * 2get connection.
 */
class ConnectionProvider{
    public void provide(){

    }
}
class HandleUserThread extends Thread{
    private Semaphore semaphore;
    private String threadName;
    private ConnectionProvider provider;

    public HandleUserThread(Semaphore semaphore, String threadName, ConnectionProvider provider) {
        this.semaphore = semaphore;
        this.threadName = threadName;
        this.provider = provider;
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
//            provider.provide();
            Thread.sleep(1000);
            System.out.println(threadName+"get connection.");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class SemaphoreDemo {
    public static void main(String[] args) {
        ConnectionProvider provider=new ConnectionProvider();
        //指定初始化可用资源的数目以及是否是公平锁
        Semaphore semaphore=new Semaphore(3,false);
        for (int i = 0; i <5 ; i++) {
            new HandleUserThread(semaphore,Integer.valueOf(i).toString(),provider).start();
        }
    }
}
