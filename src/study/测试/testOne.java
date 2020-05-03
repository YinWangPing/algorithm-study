package study.测试;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/26 21:14
 */

public class testOne extends TestTwo{
    private static testOne testOne=new testOne();
    public testOne(){
        System.out.println("子类构造方法");
    }
    {
        System.out.println("子类代码块");
    }
    static {
        System.out.println("子类静态代码块");
    }

    public static void main(String[] args) {
        new testOne();
    }

}
class  TestTwo{
    private static TestTwo a=new TestTwo();
    public TestTwo(){
        System.out.println("父类构造方法");
    }
    {
        System.out.println("父类代码块");
    }
    static {
        System.out.println("父类静态代码块");
    }
    public static void find(){
        System.out.println("静态方法");
    }
}

