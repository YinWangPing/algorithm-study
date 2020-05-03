/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/2/23 15:49
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int [] num=new int[a];
            for (int i = 0; i <a ; i++) {
                num[i]=in.nextInt();
            }
            System.out.println(calculate(num));
        }
    }
    public static String calculate(int []nums){
        int min=nums[0];
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]<min){
                min=nums[i];
            }
        }
        boolean flag=true;
        for (int i = 0; i <nums.length ; i++) {
            if(((nums[i]/min)%2)!=0&&nums[i]!=min){
                flag=false;
            }
        }
        if(flag==true) {
            return "YES";
        }else {
            return "NO";
        }
    }
}
//public class Main {
//    private static int count=0;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            count=0;
//            int a = in.nextInt();
//            System.out.println(cut(a,count));
//        }
//    }
//    public static int cut(int num,int count){
//        if(num==1){
//            return count;
//        }
//        if(num%2==0){
//            num=num/2;
//            count++;
//            return cut(num,count);
//        }else {
//            num=(3*num+1)/2;
//            count++;
//            return cut(num,count);
//        }
//    }
//}
