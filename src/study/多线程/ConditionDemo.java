import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/24 9:51
 */
class Store{
    private Lock lock;
    private Condition notFull;//阻塞队列
    private Condition notEmpty;
    private int maxSize;
    private LinkedList<String> storage;

    public Store(int maxSize) {
        lock=new ReentrantLock();
        notFull=lock.newCondition();
        notEmpty=lock.newCondition();
        this.maxSize = maxSize;
        storage=new LinkedList<String>();
    }
    //生产方法
    public void product(){
        lock.lock();
        try {
            while (storage.size()==maxSize){
                System.out.println(Thread.currentThread().getName()+":wait");
                //阻塞生产者线程
                notFull.await();
            }
            storage.add("JAVA BOOK");
            System.out.println(Thread.currentThread().getName()+":put"+storage.size());
            Thread.sleep(1000);
            notEmpty.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    //消费方法
    public void consume(){
        lock.lock();
        try {
            //如果仓库空了
            while (storage.size()==0){
                System.out.println(Thread.currentThread().getName()+":wait");
                //阻塞消费线程
                notEmpty.await();
            }
            System.out.println(storage.poll());
            System.out.println(Thread.currentThread().getName()+":left"+storage.size());
            Thread.sleep(1000);
            //唤醒生产者线程
            notFull.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
class  ProductThread implements Runnable{
    private Store store;

    public ProductThread(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true){
            store.product();
        }
    }
}
class  ConsumeThread implements Runnable{
    private Store store;

    public ConsumeThread(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true){
            store.consume();
        }
    }
}
public class ConditionDemo {
    public static void main(String[] args) {
        Store store=new Store(3);
        ProductThread productThread=new ProductThread(store);
        ConsumeThread consumeThread=new ConsumeThread(store);
        for (int i = 0; i <2 ; i++) {
            new Thread(productThread,"Producer"+i).start();
        }
        for (int i = 0; i <2 ; i++) {
            new Thread(consumeThread,"Consumer"+i).start();
        }
    }
}
