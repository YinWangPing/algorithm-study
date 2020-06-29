package study.序列化;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    transient private String address;
    private Integer age;
    private static String tel="177712333854";
    private String tag;
    public Student(){}
    public Student(String name, String address, Integer age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static String getTel() {
        return tel;
    }

    public static void setTel(String tel) {
        Student.tel = tel;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Student student=new Student("张三","湖南省隆回县",20);
//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\cug125\\Desktop\\a.txt"));
//        oos.writeObject(student);
//        ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\cug125\\Desktop\\a.txt"));
////        Student student1= (Student) ooi.readObject();
////        System.out.println(student1);
        ArrayList<Integer> list1=new ArrayList<>(150);
        for (int i = 0; i <100 ; i++) {
            list1.add(i);
        }
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\cug125\\Desktop\\a.txt"));
        oos.writeObject(list1);
        ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\cug125\\Desktop\\a.txt"));
        ArrayList<Integer>list2=(ArrayList<Integer>) ooi.readObject();
        for (int x:list2) {
            System.out.print(x+"\t");
        }
    }
}
