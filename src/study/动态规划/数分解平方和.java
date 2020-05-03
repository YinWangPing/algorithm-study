package study.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/6 22:01
 */

public class 数分解平方和 {
    public static void main(String[] args) {

    }

    public static int numSquares(int n) {
        List<Integer>list=generateSquareList(n);
        int []dp=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            int min=Integer.MAX_VALUE;
            for (int square:list) {
                if(square>i){
                    break;
                }
                min=Math.min(min,dp[i-square]+1);
            }
            dp[i]=min;
        }
        return dp[n];
    }

    private static List<Integer> generateSquareList(int n) {
        List<Integer> list = new ArrayList<>();
        int square = 1, diff = 3;
        while (square < n) {
            list.add(square);
            square += diff;
            diff += 2;
        }
        return list;
    }
}
