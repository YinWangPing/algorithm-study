package study.异常;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyException {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException, ClassNotFoundException {
        try {
            int x=3/0;
        }catch (ArithmeticException e){
            System.out.println(e.toString());
//            throw e;
//            System.exit(0);
        }finally {
            System.out.println("finally 块");
        }
        System.out.println("测试");
        String str="adc";
        Class<?>clazz=str.getClass();
        Constructor constructor=clazz.getConstructor(String.class);
        String b= (String) constructor.newInstance("adad");
        System.out.println(b+"a");
        Method method=clazz.getMethod("toCharArray");
        char[] c= (char[]) method.invoke("abcs");
        for (char ch:c){
            System.out.println(ch);
        }
        final List<Integer>list=new ArrayList<>();
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.size());
        String str1=new String("hello");
        String str2="hello";
        System.out.println(str1==str2);
        String str3=str1.intern();
        System.out.println(str2==str1);
        Integer []nums=new Integer[]{1,2,3,4,5,6,7,8,9,10};
//        ArrayList list1= new ArrayList(Arrays.asList(nums));
//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\cug125\\Desktop\\a.txt"));
//        oos.writeObject(list1);
        ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\cug125\\Desktop\\a.txt"));
        ArrayList<Integer> list2= (ArrayList) ooi.readObject();
        for (Integer i:list2){
            System.out.println(i);
            list2.remove(i);
        }
}
}
