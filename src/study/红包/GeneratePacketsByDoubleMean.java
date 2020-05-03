package study.红包;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/21 10:53
 */

public class GeneratePacketsByDoubleMean {
    public static void main(String[] args) {
        List<Double>res=generatePacketsByDoubleMean1(10,5);
        for (double i:res) {
            System.out.println(i);
        }
    }
    public static List<Integer> generatePacketsByDoubleMean(int money,int people){
        ArrayList<Integer>list=new ArrayList<>();
        Random random=new Random();
        while (people>1){
            int num=random.nextInt(2*money/people);
            list.add(num);
            money-=num;
            people--;
        }
        list.add(money);
        return list;
    }
    public static List<Double> generatePacketsByDoubleMean1(int money,int people){
        double remain=money;
        ArrayList<Double>list=new ArrayList<>();
        Random random=new Random();
        while (people>1){
            double max=remain*2/people;
            Double num=Math.floor(random.nextDouble()*max*100)/100;
            num=num<=0.01?0.01:num;
            list.add(num);
            remain-=num;
            people--;
        }
        list.add(Math.floor(remain*100)/100);
        return list;
    }
}
