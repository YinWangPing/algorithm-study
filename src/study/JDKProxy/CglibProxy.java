package study.JDKProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class BieshuHost{
    public void Rent(){
        System.out.println("出租别墅");
    }
}
class TaojianHost{
    public String rent(){
        System.out.println("出租套间");
        return "success";
    }
}
/*
实现方法拦截器接口
 */
class CglibProxySubject implements MethodInterceptor {
    private Object object;
    public Object setObject(Object object){
        this.object=object;
        //cglib中的加强器，用来创建动态代理
        Enhancer enhancer=new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(object.getClass());
        //设置回调，相当于对代理类上所有方法的调用都会调用CallBack；
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        seeHouse();
        Object res=methodProxy.invokeSuper(o,objects);
        pay();
        return res;

    }
    public void seeHouse(){
        System.out.println("中介带人看别墅");
    }
    public void pay(){
        System.out.println("客户付款，交易完成，别墅易主完成");
    }
}
public class CglibProxy {
    public static void main(String[] args) {
        BieshuHost bieshuHost= (BieshuHost) new CglibProxySubject().setObject(new BieshuHost());
        bieshuHost.Rent();
        TaojianHost taojianHost=(TaojianHost)new CglibProxySubject().setObject(new TaojianHost());
        String res=taojianHost.rent();
        System.out.println(res);
    }
}
