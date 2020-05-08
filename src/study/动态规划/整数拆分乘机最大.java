package study.动态规划;

public class 整数拆分乘机最大 {
    /*
    动态规划
     */
    public int integerBreak(int n) {
        int []dp=new int[n+1];
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=i-1 ; j++) {
                dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,j*(i-j)));
            }
        }
        return dp[n];
    }
    /*
    直接计算
     */
    public int integerBreak1(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
//        if(n<3){
//            return 1;
//        }else if(n==3){
//            return 2;
//        }
//        int x=n%3;
//        int y=n/3;
//        if(x==1){
//            int res=1;
//            for (int i = 0; i <y-1 ; i++) {
//                res*=3;
//            }
//            res*=4;
//            return res;
//        }else if(x==2){
//            int res=1;
//            for (int i = 0; i <y ; i++) {
//                res*=3;
//            }
//            res*=2;
//            return res;
//        }else{
//            int res=1;
//            for (int i = 0; i <y ; i++) {
//                res*=3;
//            }
//            return res;
//        }
    }

}
