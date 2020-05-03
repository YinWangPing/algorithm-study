package study.笔试;

import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/20 15:51
 */

public class 京东 {

///**
// * @description:
// * @author: WangPingYin
// * @time: 2020/4/18 17:52
// */
//
//public class Main {
//    public static void main(String[] args) {
//
//    }
//}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[][] nums = new int[n][2];
            for (int i = 0; i < n; i++) {
                nums[i][0] = in.nextInt();
                nums[i][1] = in.nextInt();
            }

//            System.out.println(calculate(nums,n));
        }

    }
//    public static int calculate(int [][]nums,int n){
//
////        if(n%2==0){
////            return n-4;
////        }else if(n%3==0){
////            return n;
////        }else {
////            return n-3;
////        }
//    }
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()){
//            int n=in.nextInt();
//            for (int j = 0; j < n; j++) {
//                int [][]graph=new int[6][2];
//                for (int i = 0; i < 6; i++) {
//                    graph[i][0] = in.nextInt();
//                    graph[i][1] = in.nextInt();
//                    if (graph[i][0] < graph[i][1]) {
//                        int temp = graph[i][0];
//                        graph[i][0] = graph[i][1];
//                        graph[i][1] = temp;
//                    }
//                }
//                boolean flag = calculate(graph);
//                if (flag) {
//                    System.out.println("POSSIBLE");
//                } else {
//                    System.out.println("IMPOSSIBLE");
//                }
//            }
//        }
//
//    }
//    public static boolean calculate(int[][]graph){
//        for (int i = 0; i <graph.length ; i++) {
//            for (int j = 0; j <graph.length-i-1 ; j++) {
//                if(graph[j][0]<graph[j+1][0]){
//                    int temp=graph[j][0];
//                    graph[j][0]=graph[j+1][0];
//                    graph[j+1][0]=temp;
//                    temp=graph[j][1];
//                    graph[j][1]=graph[j+1][1];
//                    graph[j+1][1]=temp;
//                }
//                if(graph[j][0]==graph[j+1][0]&&graph[j][1]<graph[j+1][1]){
//                    int temp=graph[j][1];
//                    graph[j][1]=graph[j+1][1];
//                    graph[j+1][1]=temp;
//                }
//            }
//        }
//        boolean flag=true;
//        for (int i = 0; i <5 ; i=i+2) {
//            if(graph[i][0]!=graph[i+1][0]||graph[i][1]!=graph[i+1][1]){
//                flag=false;
//            }
//        }
//        if(graph[0][0]!=graph[2][0]||graph[0][1]!=graph[4][0]||graph[2][1]!=graph[4][1]){
//            flag=false;
//        }
//        return flag;
//    }
}
