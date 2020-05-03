package study.线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/11 10:42
 */
class MyCallableTest implements Callable<String> {
    private int cnt = 0;
    public volatile boolean flag = true;

    public String call() {
        while (flag) {
            cnt++;
        }
        return Thread.currentThread().getName() + "\t" + cnt;
    }
}
public class CallableDemo{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallableTest callable=new MyCallableTest();
        FutureTask<String> futureTask=new FutureTask<String>(callable);
        new Thread(futureTask).start();
        Thread.sleep(10);
        callable.flag=false;
        System.out.println(futureTask.get());

    }
}
