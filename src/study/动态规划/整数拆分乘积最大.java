package study.动态规划;

/**
 * @description:给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * @author: WangPingYin
 * @time: 2020/4/6 21:30
 */

public class 整数拆分乘积最大 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n) {
        int []dp=new int[n+1];
        dp[1]=1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <i ; j++) {
                dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,j*(i-j)));
            }
        }
        return dp[n];
    }
    public static int integerBreak1(int n) {
        if(n<4){
            return n-1;
        }
        int mod=n%3,div=n/3;
        if(mod==0){
            return (int) Math.pow(3,div);
        }
        if(mod==1){
            return (int) (Math.pow(3,div-1)*4);
        }
        return (int) (Math.pow(3,div)*2);
    }
}
