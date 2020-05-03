package study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/15 10:36
 */
class user {
    private int id;
    private String name;
    private String address;

    public user() {
    }

    public user(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public user(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public String getInfo(int id,String name,String address) {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

public class ReflectGetInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz=Class.forName("study.reflect.user");
        user a=(user) clazz.newInstance();
        a.setId(1);
        a.setName("fdefweq");
        a.setAddress("湖南");
        System.out.println(a.getInfo());
        Constructor constructor =clazz.getConstructor(int.class,String.class);
        user b=(user) constructor.newInstance(2,"efqwf");
        System.out.println(b.getInfo());
        Constructor constructor1=clazz.getConstructor(int.class,String.class,String.class);
        user c=(user) constructor1.newInstance(3,"zhangsan","邵东");
        System.out.println(c.getInfo());
        Method method=clazz.getMethod("getInfo",int.class,String.class,String.class);
        String res= (String) method.invoke(clazz.newInstance(),4,"alass","tuansahn");
        System.out.println(res);
    }
}
