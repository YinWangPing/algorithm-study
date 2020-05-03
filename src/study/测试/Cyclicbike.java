package study.测试;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/27 16:21
 */

public class Cyclicbike extends Car{
    @Override
    protected void run() {
        System.out.println("自行车Run");
    }

    public static void main(String[] args) {
        Cyclicbike bike=new Cyclicbike();
        bike.run();
    }
}
