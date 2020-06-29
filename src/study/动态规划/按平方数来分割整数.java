package study.动态规划;

import java.util.ArrayList;
import java.util.List;

public class 按平方数来分割整数 {
    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
    private List<Integer> generateSquareList(int n) {
        List<Integer> res=new ArrayList<>();
        int dif=3,square=1;
        for (int i = square; i <=n ; i++) {
            res.add(square);
            square+=dif;
            dif+=2;
        }
        return res;
    }



















    public int numSquares1(int n) {
        List<Integer> square=generateSquare(n);
        int []dp=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            int min=Integer.MAX_VALUE;
            for (Integer s:square) {
                if(s>i){
                    break;
                }
                min=Math.min(min,dp[i-s]+1);
            }
            dp[i]=min;
        }
        return dp[n];
    }
    public List<Integer> generateSquare(int n){
        List<Integer> list=new ArrayList<>();
        int diff=3,square=1;
        while (square<=n){
            list.add(square);
            square+=diff;
            diff+=2;
        }
        return list;
    }
}
