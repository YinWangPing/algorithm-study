/**
 * @description:实现单例模式
 * @author: WangPingYin
 * @time: 2020/2/12 20:01
 */

/**
 * 饿汉式单例设计模式，线程安全
 * 饿汉式是典型的空间换时间，当类装载的时候就会创建类实例，
 * 不管你用不用，先创建出来，然后每次调用的时候，就不需要判断了，节省了运行时间。
 * 步骤：
 * 1，创建并初始化private static final变量(一般final变量名大写)
 * 2.私有化构造方法
 * 3.创建返回单例对象的public static getInstance方法
 */
class Singleton1 {
    //使用final保证Singleton类内部的instance无法再次实例化
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    private static Singleton1 getInstance() {
        return INSTANCE;
    }

    public static void test() {
        Singleton1 object1 = Singleton1.getInstance();
        Singleton1 object2 = Singleton1.getInstance();
        //输出为true
        System.out.println("object1是否和object2相同:" + object1.equals(object2));
    }
}

/**
 * 懒汉式单例设计模式，线程不安全
 * 步骤：
 * 1，创建并初始化private static 变量(变量名大写)
 * 2.私有化构造方法
 * 3.创建返回单例对象的public static getInstance方法,
 * 如果不存在实例则创建，然后返回；
 */
class Singleton2 {
    private static Singleton2 INSTANCE;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }

    public static void test() {
        Singleton2 object1 = Singleton2.getInstance();
        Singleton2 object2 = Singleton2.getInstance();
        //输出为true，但多线程同时执行时，会造成线程不安全
        System.out.println("object1是否和object2相同:" + object1.equals(object2));
    }
}

/**
 * 静态代码块懒汉式，线程安全
 */
class Singleton3 {
    private static Singleton3 INSTANCE;

    static {
        INSTANCE = new Singleton3();
    }

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return INSTANCE;
    }

    public static void test() {
        Singleton3 object1 = Singleton3.getInstance();
        Singleton3 object2 = Singleton3.getInstance();
        //输出为true，线程安全
        System.out.println("object1是否和object2相同:" + object1.equals(object2));
    }
}

/**
 * 推荐
 * 使用静态内部类实现的单例模式，线程安全
 * 当getInstance方法第一次被调用的时候,它第一次读取SingletonHolder.instance，
 * 导致SingletonHolder类得到初始化；而这个类在装载并被初始化的时候，
 * 会初始化它的静态域，从而创建Singleton的实例，由于是静态的域，
 * 因此只会在虚拟机装载类的时候初始化一次，并由虚拟机来保证它的线程安全性。
 */
class Singleton4 {
    private final static class SingletonHolder {
        private final static Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }


    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void test() {
        Singleton4 object1 = Singleton4.getInstance();
        Singleton4 object2 = Singleton4.getInstance();
        //输出为true，线程安全
        System.out.println("object1是否和object2相同:" + object1.equals(object2));
    }
}

/**
 * synchronized懒汉式，线程安全，多线程环境下效率不高
 */
class Singleton5 {
    private static Singleton5 INSTANCE;

    private Singleton5() {
    }

    public static synchronized Singleton5 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton5();
        }
        return INSTANCE;
    }

    public static void test() {
        Singleton5 object1 = Singleton5.getInstance();
        Singleton5 object2 = Singleton5.getInstance();
        //输出为true，线程安全
        System.out.println("object1是否和object2相同:" + object1.equals(object2));
    }
}

/**
 * 懒汉式（推荐）
 * （双重校验锁）双重空校验+中间的synchronized代码块，线程安全
 */
class Singleton6 {
    //volatile 关键字
    private volatile static Singleton6 INSTANCE;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton6.class) {
                if (INSTANCE == null) INSTANCE = new Singleton6();
            }
        }
        return INSTANCE;
    }

    public static void test() {
        Singleton6 object1 = Singleton6.getInstance();
        Singleton6 object2 = Singleton6.getInstance();
        //输出为true，线程安全
        System.out.println("object1是否和object2相同:" + object1.equals(object2));
    }
}

enum Singleton7 {
    INSTANCE;

    public static void test() {
        Singleton7 object1 = Singleton7.INSTANCE;
        Singleton7 object2 = Singleton7.INSTANCE;
        //输出为true，线程安全
        System.out.println("object1是否和object2相同:" + object1.equals(object2));
    }
}

public class JZOF_002 {
    public static void main(String[] args) {
        Singleton1.test();
        Singleton2.test();
        Singleton3.test();
        Singleton4.test();
        Singleton5.test();
        Singleton6.test();
        Singleton7.test();
    }
}
