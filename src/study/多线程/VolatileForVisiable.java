import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 10:47
 */

public class VolatileForVisiable extends Thread{
    volatile private boolean stopFlag=false;
//    boolean stopFlag=false;
    private int cnt=0;
    @Override
    public void run() {
        super.run();
        while (!stopFlag){
            cnt++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileForVisiable obj=new VolatileForVisiable();
        obj.start();
        Thread.sleep(5000);
        obj.stopFlag=true;
        System.out.println(obj.cnt);
    }
}
