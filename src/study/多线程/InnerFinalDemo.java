import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/24 15:29
 */

public class InnerFinalDemo {
    public static int addByThreads(final List list){
        //创建一个线程组
        ThreadGroup group=new ThreadGroup("Group");
        //通过内部类的方法来创建多线程
        Runnable listAddTool =new Runnable() {
            @Override
            public void run() {
                list.add("0");
            }
        };
        //启动10个线程，同时向集合里添加元素
        for (int i = 0; i <10 ; i++) {
            new Thread(group,listAddTool).start();
        }
        while (group.activeCount()>0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        List list=new ArrayList();
        System.out.println(addByThreads(list));
    }
}
