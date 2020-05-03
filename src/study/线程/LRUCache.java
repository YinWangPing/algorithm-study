package study.线程;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/4 10:07
 */

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private static final int MAX_ENTRIES=3;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>MAX_ENTRIES;
    }
    LRUCache(){
        super(MAX_ENTRIES,0.75f,true);
    }

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        Properties properties=new Properties();
        properties.setProperty("111","中文");
        properties.setProperty("222","adc");
        properties.setProperty("333","333");
        properties.setProperty("444","444");
        properties.store(new FileOutputStream("D://test.properties"),"test");
        Properties propertie=new Properties();
        propertie.load(new FileInputStream("D://test.properties"));
        System.out.println(propertie.getProperty("111"));
        System.out.println(propertie.getProperty("222"));
        LRUCache<Integer,String> cache=new LRUCache();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
        short s1=1;
        s1= (short) (s1+1);
        Integer x = new Integer(1);
        Integer y = new Integer(1);
        System.out.println(x.equals(y)); // true

        System.out.println(x == y);


        Book book=new Book(123,"星辰变");
        Student studenta=new Student(1,"张三",book);
//        studenta.setBook(book);
        Student studentb=(Student)studenta.clone();
//        studentb.setBook(book);
        System.out.println("-------------------");
        System.out.println(studenta);
        System.out.println(studentb);
        System.out.println("-------------------");
        System.out.println(studenta.equals(studentb));
        book.setBook_name("哈哈哈");
        System.out.println(studenta.getBook());
        System.out.println(studentb.getBook());
    }
}
