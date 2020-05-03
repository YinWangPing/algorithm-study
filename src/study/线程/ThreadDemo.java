package study.线程;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/3 14:43
 */

class AddThread implements Runnable{
    private Resource resource;
    public AddThread(Resource resource){
        this.resource=resource;
    }
    @Override
    public void run() {
        for (int i = 0; i <50 ; i++) {
            try {
                this.resource.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class SubThread implements Runnable{
    private Resource resource;
    public SubThread(Resource resource){
        this.resource=resource;
    }
    @Override
    public void run() {
        for (int i = 0; i <50 ; i++) {
            try {
                this.resource.sub();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Resource {
    private int num = 0;
    private boolean flag = true;//true表示执行加法操作，false表示执行减法操作

    public synchronized void add() throws InterruptedException {
        if(this.flag==false){//若为false则需要执行减法操作，加法操作需要等待
            super.wait();
        }
        Thread.sleep(100);
        num++;
        System.out.println("加法操作" + Thread.currentThread().getName() + "***数字为" + this.num);
        this.flag=false;
        super.notifyAll();//唤醒等待的第一个线程
    }

    public synchronized void sub() throws InterruptedException {
        if(this.flag==true){//若为true则需要执行加法操作，减法操作需要等待
            super.wait();
        }
        Thread.sleep(100);
        num--;
        System.out.println("减法操作" + Thread.currentThread().getName() + "***数字为" + this.num);
        this.flag=true;
        super.notifyAll();//唤醒等待的第一个线程
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Resource resource=new Resource();
        AddThread at=new AddThread(resource);
        SubThread st=new SubThread(resource);
        new Thread(at,"加法线程1").start();
        new Thread(st,"减法线程1").start();
        new Thread(at,"加法线程2").start();
        new Thread(st,"减法线程2").start();
    }
}
