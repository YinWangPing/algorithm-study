package study.测试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/28 15:09
 */

public class People implements Comparable<People> {
    private int id;
    private String name;
    private String address;

    public People() {
    }

    ;

    public People(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(People o) {
        return this.name.compareTo(o.name);
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
        People people1 = new People(1, "adc", "湖南邵东");
        People people2 = new People(2, "ade", "湖南测试");
        People people3 = new People(3, "ada", "湖南得分");
        List<People> list = new ArrayList<>();
        list.add(people1);
        list.add(people2);
        list.add(people3);
        Collections.sort(list);
        for (People peo : list) {
            System.out.println(peo);
        }

    }

}
