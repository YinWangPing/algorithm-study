package study.JDKProxy;

import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Mytest {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        File file=new File(".");
        System.out.println(file.getCanonicalPath());
        InputStream inputStream=new FileInputStream("C:\\Users\\cug125\\Desktop\\algorithm-study\\out\\production\\algorithm-study\\study\\JDKProxy\\Programmer.class");
        byte [] result =new byte[1024];
        int count=inputStream.read(result);
        MyClassLoader loader=new MyClassLoader();
        Class clazz=loader.defineMyClasss(result,0,count);
        System.out.println(clazz.getCanonicalName());
        Object o=clazz.newInstance();
        clazz.getMethod("code").invoke(o);
    }
}
