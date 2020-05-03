import java.util.*;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/16 10:09
 */
interface Eat {
    default void test() {
        System.out.println("sdaf");
    }

    public void eat();
}

interface Sleep {
    public void sleep();
}

class Person implements Eat, Sleep {

    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("睡觉");
    }
}
class Dog implements Eat{

    @Override
    public void eat() {
        System.out.println("狗吃东西");
    }
}
class Cat implements Eat{

    @Override
    public void eat() {
        System.out.println("猫吃东西");
    }
}
class EatFactory {
//    private Eat eat；
    public Eat getInstance(String name){
        if(name=="cat"){
            return new Cat();
        }
        if (name=="dog"){
            return new Dog();
        }
        return null;
    }
}
class CarForDeepCopyy implements Cloneable{
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public CarForDeepCopyy(int id){
        this.id=id;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        CarForDeepCopyy car=new CarForDeepCopyy(1);
        CarForDeepCopyy car2= (CarForDeepCopyy) car.clone();
//        car.setId(1);
        ArrayList<CarForDeepCopyy> a1=new ArrayList<CarForDeepCopyy>();
        ArrayList<CarForDeepCopyy> a2=new ArrayList<CarForDeepCopyy>();
        a1.add(car);
        a2.add(car2);
        a1.get(0).setId(2);
        System.out.println(a2.get(0).getId());
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        ArrayList<String> arrayList=new ArrayList<>();
        LinkedList<String> linkedList=new LinkedList<>();
        HashSet<String> hashSet=new HashSet<String>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        Iterable iterable= (Iterable) hashSet.iterator();
        for (String str:hashSet) {
            System.out.println(str);
        }
//        System.out.println(1 << 4);
//        Sleep sleep = new Person();
//        Eat eat = (Eat) sleep;
//        eat.eat();
//        eat.test();
//        EatFactory eatFactory=new EatFactory();
//         Eat eat1=eatFactory.getInstance("dog");
//         eat1.eat();
//        Eat eat2=eatFactory.getInstance("cat");
//        eat2.eat();
    }
}
