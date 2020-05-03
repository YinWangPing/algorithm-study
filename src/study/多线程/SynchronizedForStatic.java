/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 11:36
 */

public class SynchronizedForStatic implements Runnable {
    private static int count = 0;

    public synchronized static void staticFun() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        staticFun();
    }

    public static void main(String[] args) {
        SynchronizedForStatic synchronizedForStatic1 = new SynchronizedForStatic();
        SynchronizedForStatic synchronizedForStatic2 = new SynchronizedForStatic();
        Thread thread1 = new Thread(synchronizedForStatic1, "t1");
        Thread thread2 = new Thread(synchronizedForStatic2, "t2");
        thread1.start();
        thread2.start();
    }
}
