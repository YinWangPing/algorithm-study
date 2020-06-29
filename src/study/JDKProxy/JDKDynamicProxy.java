package study.JDKProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Rent{
    public abstract void rent();
}
class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房主出租");
    }
}
class RoomMaster implements Rent{

    @Override
    public void rent() {
        System.out.println("别墅出租");
    }
}
class ProxySubject implements InvocationHandler {
    private Object object;
    public Object setObject(Object object){
        this.object=object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        Object o=method.invoke(object,args);
        pay();
        return o;
    }
    public void seeHouse(){
        System.out.println("中介带人看房");
    }
    public void pay(){
        System.out.println("客户付款，交易完成");
    }
}
class ProxySubject1 implements InvocationHandler{
    private Object object;
    public Object setObject(Object object){
        this.object=object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        Object result=method.invoke(object,args);
        pay();
        save();
        return result;
    }
    public void save(){
        //根据类信息和提供的代理类名称，生成字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(object.getClass().getName(),object.getClass().getInterfaces());
        String paths = "D:\\temp\\";
        System.out.println(paths);
        FileOutputStream out = null;

        try {
            //保留到硬盘中
            out = new FileOutputStream(paths+object.getClass().getName()+".class");
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void seeHouse(){
        System.out.println("中介带人看别墅");
    }
    public void pay(){
        System.out.println("客户付款，交易完成，别墅易主");
    }
}
public class JDKDynamicProxy {
    public static void main(String[] args) {;
//        Rent rent= (Rent) new ProxySubject().setObject(new Host());
//        rent.rent();
//        Rent rent1=(Rent) new ProxySubject().setObject(new RoomMaster());
//        rent1.rent();
        Rent rent2= (Rent) new ProxySubject1().setObject(new RoomMaster());
        rent2.rent();
    }
}
