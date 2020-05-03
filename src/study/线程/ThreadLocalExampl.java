package study.线程;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/3 16:53
 */

public class ThreadLocalExampl {
    public static void main(String[] args) throws IOException {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal.set("11111");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t:" + threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set(3);
            System.out.println(Thread.currentThread().getName() + "\t:" + threadLocal.get());
            threadLocal.remove();
            System.out.println(Thread.currentThread().getName() + "\t:" + threadLocal.get());
        });
        thread1.start();
        thread2.start();
        String s=null;
        String str=s+"fasdf";
        System.out.println(str);
        Iterator iterator= new HashSet<String>().iterator();
        ArrayList list = new ArrayList();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file"));
        oos.writeObject(list);
    }
}

