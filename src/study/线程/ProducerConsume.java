package study.线程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/3 11:23
 */
/**
 *java.util.concurrent.BlockingQueue 接口有以下阻塞队列的实现：
 *
 * FIFO 队列 ：LinkedBlockingQueue、ArrayBlockingQueue（固定长度）
 * 优先级队列 ：PriorityBlockingQueue
 * 提供了阻塞的 take() 和 put() 方法：如果队列为空 take() 将阻塞，直到队列中有内容；如果队列为满 put() 将阻塞，直到队列有空闲位置。
 *
 * 使用 BlockingQueue 实现生产者消费者问题
 */
public class ProducerConsume {
    BlockingQueue<String> queue=new ArrayBlockingQueue<String>(5);
    private class Producer implements Runnable{
        @Override
        public void run() {
            try {
                queue.put("bread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("produce food");
        }
    }
    private class Consumer implements Runnable{
        @Override
        public void run() {
            try {
                String product=queue.take();
                System.out.println("consume food:"+product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ProducerConsume producerConsume=new ProducerConsume();
        for (int i = 0; i <2 ; i++) {
            new Thread(producerConsume.new Producer()).start();
        }
        for (int i = 0; i <5 ; i++) {
            new Thread(producerConsume.new Consumer()).start();
        }
        for (int i = 0; i <3 ; i++) {
            new Thread(producerConsume.new Producer()).start();
        }
    }
}
