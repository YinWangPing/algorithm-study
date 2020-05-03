package study.测试;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/27 16:19
 */

abstract class Car {
    private int id;
    private static String name;
    public Car() {
        System.out.println("Car类构造方法");
    }
    public Car(int id) {
        this.id = id;
    }

    protected abstract void run();
    protected static void test(){
        System.out.println("Car...test");
    }
}
