package study.测试;

import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/26 17:59
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int num=scanner.nextInt();
            int len=scanner.nextInt();
        }
//        while (scanner.hasNextLine()){
//            int num=Integer.valueOf(scanner.nextLine());
//            for (int i = 0; i <num ; i++) {
//                int len=Integer.valueOf(scanner.nextLine());
//                String str=scanner.nextLine();
//                String []res=str.split(" ");
//                System.out.println(calculate(res));
//            }
//        }
//        while (scanner.hasNextInt()){
//            int num=scanner.nextInt();
//            for (int i = 0; i <num ; i++) {
//                int len=scanner.nextInt();
//                int []nums=new int[len];
//                for (int j = 0; j <len ; j++) {
//                    nums[j]=scanner.nextInt();
//                }
//                System.out.println(calculate(nums));
//            }
//        }
    }

//    public static void Sum(int N ,int L){
//
//        if(L <= 100 && L < N){
//            //奇数
//            if(L % 2 == 1 && N % L == 0 && N/L - L/2 >= 0){
//                int startIndex = N/L - L/2, endIndex = N/L + L/2;
//                for(int i =startIndex; i < endIndex; i++)
//                    System.out.print(i + " ");
//                System.out.print(endIndex);
//                System.out.println();
//                return;
//            }
//            //偶数
//            if(L % 2 == 0 && N % L == L/2 && N/L + 1 - L/2 >= 0){
//                int startIndex = N/L + 1 - L/2, endIndex = N/L + L/2;
//                for(int i = startIndex; i < endIndex; i++)
//                    System.out.print(i + " ");
//                System.out.print(endIndex);
//                System.out.println();
//                return;
//            }
//            Sum(N, L + 1);
//
//        }else
//            System.out.println("No");
//    }
//    public static int calculate(int []nums){
//        int num=0,count0=0;
//        boolean flag=true;
//        for (int i = 0; i <nums.length ; i++) {
//            if(nums[i]!=0){
//                num+=1;
//            }else {
//                count0++;
//            }
//        }
//        if(num==0){
//            return -1;
//        }
//        if(count0==0){
//            return num+1;
//        }else {
//            return num + count0;
//        }
//    }
//    public static int calculate(String []nums){
//        int num=0;
//        for (int i = 0; i <nums.length ; i++) {
//            if(Integer.valueOf(nums[i])!=0){
//                num+=1;
//                if(Integer.valueOf(nums[i])==1){
//                    num+=1;
//                }
//            }
//        }
//        if(num==0){
//            return -1;
//        }
//        return num+1;
//    }
}
