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
}
