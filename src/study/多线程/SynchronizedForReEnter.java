/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 11:52
 */
class Sync{
    synchronized public void func1(){
        System.out.println("func1");
        func2();
    }
    synchronized public void func2(){
        System.out.println("func2");
    }
}
public class SynchronizedForReEnter extends Thread{
    @Override
    public void run() {
        Sync sync=new Sync();
        sync.func1();
    }

    public static void main(String[] args) {
        new SynchronizedForReEnter().run();
    }
}
