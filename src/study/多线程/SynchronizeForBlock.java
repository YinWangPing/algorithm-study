/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 11:12
 */

public class SynchronizeForBlock implements Runnable{
    private static int cnt=0;

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i <3 ; i++) {
                try {
                    System.out.println(Thread.currentThread().getName()+"i"+(cnt++));
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        //-------------------------------------------------------------------
//        SynchronizeForBlock synchronizeForBlock=new SynchronizeForBlock();
//        Thread thread1=new Thread(new SynchronizeForBlock(),"t1");//不同对象触发
//        Thread thread2=new Thread(new SynchronizeForBlock(),"t2");
//        thread1.start();
//        thread2.start();
//        //此时t1和t2交替输出，synchronized锁住的是点用该代码块的对象，
//        // 由于两对象不同所以t1和t2会交替打印
        //-------------------------------------------------------------------
        SynchronizeForBlock synchronizeForBlock=new SynchronizeForBlock();
        Thread thread1=new Thread(synchronizeForBlock,"t1");//相同对象触发
        Thread thread2=new Thread(synchronizeForBlock,"t2");
        thread1.start();
        thread2.start();
        //此时t1输出完t2才输出，synchronized锁住的是进入该线程的对象
    }
}
