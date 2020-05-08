package study.动态规划;

import java.util.Arrays;

public class 矩阵中的不同路径数 {
    public int uniquePaths(int m, int n) {
        int[]dp=new int[n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(i==0||j==0){
                    dp[j]=1;
                }else if(i!=0&&j!=0){
                    dp[j]=dp[j]+dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
