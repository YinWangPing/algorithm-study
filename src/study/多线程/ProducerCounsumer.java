/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 20:36
 */
class ProductData{
    //表示被哪个生产者线程生产出来的编号
    private int number;
    //标志位，true表示已消费
    private boolean flag=true;
    public synchronized void product(int number){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.number=number;
        flag=false;
        notify();
    }
    public synchronized int consume(){
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        this.number=number;
        flag=true;
        notify();
        return this.number;
    }
}
class Producer extends Thread{
    private ProductData productData;
    public Producer(ProductData productData) {
        this.productData = productData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            productData.product(i);
            System.out.println("p["+i+"]product,");
        }

    }
}
class Consumer extends Thread{
    private ProductData productData;
    public Consumer(ProductData productData) {
        this.productData = productData;
    }

    @Override
    public void run() {
        int i;
        do{
            i=productData.consume();
            System.out.println("p["+i+"]consume,");
        }while (i!=9);

    }
}
public class ProducerCounsumer {
    public static void main(String[] args) {
        ProductData data=new ProductData();
        new Producer(data).start();
        new Consumer(data).start();
    }
}
