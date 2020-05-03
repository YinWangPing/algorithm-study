import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/22 15:23
 */

public class ThreadSafeDemo {
    public static void main(String[] args) {
        List unsafeList=new ArrayList();
        List safeList= Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i <3 ; i++) {
            unsafeList.clear();
            safeList.clear();
            int unsafeSize=addByThread(unsafeList,"unsafe");
            int safeSize=addByThread(safeList,"safe");
            System.out.println("unsafe/safe"+":\t"+unsafeSize+"/"+safeSize);
        }
    }
    public static int addByThread(final List list,String type){
        ThreadGroup group=new ThreadGroup(type);
        Runnable listAddTool=new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                list.add("0");
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i <10000 ; i++) {
            new Thread(group,listAddTool).start();
        }
        //多个线程之间sleep10毫秒，避免线程互相干扰
        while (group.activeCount()>0){
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return list.size();
    }
}
