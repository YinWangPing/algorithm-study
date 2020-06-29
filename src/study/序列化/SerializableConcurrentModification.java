package study.序列化;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableConcurrentModification {
    public static void main(String[] args) {
        ArrayList<Integer> list1=new ArrayList<>(150);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    list1.add(i);
                }
            }
        });
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectOutputStream oos= null;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\cug125\\Desktop\\a.txt"));
                    oos.writeObject(list1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        thread1.start();
    }
}
