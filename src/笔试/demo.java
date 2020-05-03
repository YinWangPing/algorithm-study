package 笔试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/29 10:02
 */

public class demo {
    public static void main(String[] args) {
//        ArrayList
//        Integer []nums=new Integer[]{33,44,61,2,36,42,56,81,11,17};
//        Integer []res=find(nums);
//        for (Integer i:res) {
//            System.out.println(i);
//        }
        try{
            int i=10/0;
        }catch(ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println(Integer.parseInt("111")/2);
        demo dm=new demo();
        System.out.println(dm.calculate1("10+23-5"));
    }
    public int calculate1(String string){
        int result=0;
        String str = string.trim().replaceAll("\\-", "\\+\\-");
        String[] expArr = str.split("\\+");
        for(int i=0; i<expArr.length; i++){
            if(!expArr[i].equals("")){
                result = result+Integer.valueOf(expArr[i]);
            }
        }
        return result;
    }
//    public int cal(String ex) {
////        int result = 0;
////        String[] strs = ex.split("\\+");
////        for (int i = 0; i < strs.length; i++) {
////            String[] str = strs[i].split("\\-");
////            for (int j = 0; j < str.length; j++) {
////                result += Integer.parseInt(str[j]);
////            }
////        }
////        return result;
//    }
    public int calculate(String str){
        List<Integer>num=new ArrayList<>();
        List<Character>characters=new ArrayList<>();
        int index=0;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                sb.append(str.charAt(i));
            }else if(str.charAt(i)=='+'||str.charAt(i)=='-'){
                characters.add(str.charAt(i));
                index=i;
                num.add(Integer.valueOf(sb.toString()));
                sb.delete(0,sb.length());
            }
            if(i==str.length()-1){
                num.add(Integer.valueOf(sb.toString()));
            }
        }
//        for (int i = 0; i < ; i++) {
//
//        }
        return 0;
    }
    public String add(String a, String b) {
        int carryBit = 0;
        int sum = 0;
        StringBuilder result = new StringBuilder();
        while (a.length() != b.length()) {
            if (a.length() > b.length()) {
                b = "0" + b;
            } else {
                a = "0" + a;
            }
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            sum = a.charAt(i) - '0' + b.charAt(i) - '0' + carryBit;
            if (sum >= 3) {
                result.append((char) (sum - 3 + '0'));
                carryBit = 1;
            } else {
                result.append((char) (sum + '0'));
                carryBit = 0;
            }
        }
        if (carryBit == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }
    public static Integer[] find(Integer[] nums){
        Integer sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
        }
        Double x=sum*1.0/nums.length;
        List<Double> res=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            res.add(nums[i]-x);
        }
        Collections.sort(res, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(Math.abs(o1)-Math.abs(o2)>0){
                    return 1;
                }else if(Math.abs(o1)-Math.abs(o2)==0){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
        Integer[]num=new Integer[3];
        num[0]=new Double(x+res.get(0)).intValue();
        num[1]=new Double(x+res.get(1)).intValue();
        num[2]=new Double(x+res.get(2)).intValue();
        return num;
    }
}
