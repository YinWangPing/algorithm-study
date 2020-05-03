package study.测试;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/28 17:35
 */

public class StaticTest {
    private int id;
    private static String name="adc";
    public StaticTest(){};
    public StaticTest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        StaticTest.name = name;
    }

    @Override
    public String toString() {
        return "StaticTest{" +
                "id=" + id +
                '}';
    }
    static class man{
        private int age;
        public int count;
        public void test(){
            System.out.println("test");
            System.out.println(name);
        }

    }
    public static void main(String[] args) {
        StaticTest staticTest=new StaticTest(1);
        StaticTest.man man=new StaticTest.man();
        man.test();
    }
}
