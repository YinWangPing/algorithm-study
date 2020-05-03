package study.设计模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/6 14:41
 */
interface Rent{
    void rent();
}
class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房主出租");
    }
}
class ProxyInvocationHandle implements InvocationHandler{
    private Object object;
    public Object setObject(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        Object results=method.invoke(object,args);
        pay();
        return results;
    }
    public void seeHouse(){
        System.out.println("中介带人看房");
    }
    public void pay(){
        System.out.println("客户付款，交易完成");
    }
}
public class DynamicProxy {
    public static void main(String[] args) {
        Rent rent= (Rent) new ProxyInvocationHandle().setObject(new Host());
        rent.rent();
    }
}
