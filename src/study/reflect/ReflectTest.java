package study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/5 10:01
 */
class MethodClass {
    public final int NUM = 3;
    private int id;
    protected String name;
    String address;

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz1=String.class;
        Constructor constructor=clazz1.getConstructor(String.class);
        String string0=(String)clazz1.newInstance();
        System.out.println(string0.toString()+(string0.equals("")));
        String string1=(String)constructor.newInstance("adc");
        String string2=new String("adc");
        System.out.println(string1.equals(string2));
        System.out.println("---------------------------------------");
        //        Class<?>clazz=MethodClass.class;
        Class<?> clazz = Class.forName("study.reflect.MethodClass");
        //-------------------------------------------------------------
        //获取并调用add方法
        Object object = clazz.newInstance();
        Method method=clazz.getMethod("add",int.class,int.class);
        Object result=method.invoke(object,3,5);
        System.out.println(result);
        //-------------------------------------------------------------
        Method[] methods = clazz.getMethods();
        System.out.println("getMethods获取的方法---------------");
        for (Method m : methods) {
            System.out.println(m);
        }
        /*res:
        getMethods获取的方法---------------
        public int study.reflect.MethodClass.add(int,int)
        public int study.reflect.MethodClass.sub(int,int)
        public final void java.lang.Object.wait() throws java.lang.InterruptedException
        public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
        public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
        public boolean java.lang.Object.equals(java.lang.Object)
        public java.lang.String java.lang.Object.toString()
        public native int java.lang.Object.hashCode()
        public final native java.lang.Class java.lang.Object.getClass()
        public final native void java.lang.Object.notify()
        public final native void java.lang.Object.notifyAll()*/
        //-------------------------------------------------------------
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("getDeclaredMethods获取的方法---------------");
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
        /*res:
        getDeclaredMethods获取的方法---------------
        public int study.reflect.MethodClass.add(int,int)
        public int study.reflect.MethodClass.sub(int,int)*/
        //-------------------------------------------------------------
        //访问公有的成员变量
        Field[] fields = clazz.getFields();
        System.out.println("getFields获取的属性---------------");
        for (Field f : fields) {
            System.out.println(f);
        }
        Field field=clazz.getField("NUM");
        Object instance=clazz.newInstance();
        System.out.println(field.getName()+"\t"+field.get(instance));
        field.setAccessible(true);
//        修改static final属性，通过先将final属性去除再进行修改
//        Field modifiers = field.getClass().getDeclaredField("modifiers");
//        modifiers.setAccessible(true);
//        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
//        field.set(instance,8);
//        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(instance,8);
        System.out.println(field.getName()+"\t"+field.get(instance));
        System.out.println(field.getName()+"\t"+field.get(clazz.newInstance()));
        /*res:
        getFields获取的属性---------------
        public final int study.reflect.MethodClass.NUM*/
        //-------------------------------------------------------------
        //所有已声明的成员变量，但不能得到其父类的成员变量
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println("getDeclaredFields获取的属性---------------");
        for (Field f : declaredFields) {
            System.out.println(f);
        }
        /*res:
        getDeclaredFields获取的属性---------------
        public final int study.reflect.MethodClass.NUM
        private int study.reflect.MethodClass.id
        protected java.lang.String study.reflect.MethodClass.name
        java.lang.String study.reflect.MethodClass.address*/
    }
}
