/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 9:51
 */

public class VolatileDemo {
    public static volatile int cnt=0;
    public static void add(){
        try {
            Thread.sleep(1);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        cnt++;
    }
    public static void main(String[] args) {
        VolatileDemo volatileDemo=new VolatileDemo();
        for (int i = 0; i <1000 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volatileDemo.add();
                }
            }).start();
        }
        System.out.println(VolatileDemo.cnt);
    }
}
