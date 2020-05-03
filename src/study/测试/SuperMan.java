package study.测试;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/28 15:09
 */

public class SuperMan{
    private int id;
    private String name;
    private String address;
    public SuperMan(){};
    public SuperMan(int id,String name,String address){
        this.id=id;
        this.name=name;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Runtime runtime=Runtime.getRuntime();
        ConcurrentHashMap<String,Integer> concurrentHashMap=new ConcurrentHashMap<>();
        System.out.println("最大内存"+"\t"+runtime.maxMemory()/1024/1024/1024);
        System.out.println("处理器数"+"\t"+runtime.availableProcessors());
        System.out.println("总内存"+"\t"+runtime.totalMemory()/1024/1024);
        System.out.println("空闲内存"+"\t"+runtime.freeMemory()/1024/1024);
        SuperMan people1=new SuperMan(1,"adc","湖南邵东");
        SuperMan people2=new SuperMan(2,"ade","湖南测试");
        SuperMan people3=new SuperMan(3,"ada","湖南地方");
        List<SuperMan>list=new ArrayList<>();
        list.add(people1);
        list.add(people2);
        list.add(people3);
        Collections.sort(list, new Comparator<SuperMan>() {
            @Override
            public int compare(SuperMan o1, SuperMan o2) {
                return o2.name.compareTo(o1.name);
            }
        });
        for (SuperMan peo:list) {
            System.out.println(peo);
        }

    }
}

