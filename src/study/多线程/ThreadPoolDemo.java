import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 19:38
 */
class Mythread extends Thread{
    private String name;
    public Mythread(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println("Thread"+name+"start");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread"+name+"finish");
    }
}
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(2,4,200, 
                TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5));
        for (int i = 0; i <10; i++) {
            Mythread mythread=new Mythread(Integer.valueOf(i).toString());
            threadPoolExecutor.execute(mythread);
        }
        threadPoolExecutor.shutdown();
    }
}
