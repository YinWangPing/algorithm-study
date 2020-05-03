/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 17:07
 */

class MyLocalThread {
    private ThreadLocal<Integer> localValue=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    private ThreadLocal<String>curName=new ThreadLocal<String>();
    public Integer add(){
        localValue.set(localValue.get()+1);
        return localValue.get()+1;
    }
    public String setCurName(String threadName) {
        try{
            curName.set(threadName);
            return curName.get();
        }finally {
            curName.remove();
        }
    }
}
class UseLocalThread extends Thread{
    private MyLocalThread localThread=new MyLocalThread();
    public UseLocalThread(MyLocalThread localThread){
        this.localThread=localThread;
    }

    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            System.out.println(localThread.add()+"\t"+localThread.setCurName(Thread.currentThread().getName()));
        }
    }
}
public class MyThreadLocal{
    public static void main(String[] args) {
        MyLocalThread myLocalThread=new MyLocalThread();
        Thread thread1=new UseLocalThread(myLocalThread);
        Thread thread2=new UseLocalThread(myLocalThread);
        Thread thread3=new UseLocalThread(myLocalThread);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
