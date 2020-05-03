package study.动态规划;

/**
 * @description:函数要返回等差数组数组 A 中所有为等差数组的子数组个数。
 * @author: WangPingYin
 * @time: 2020/4/6 21:17
 */

public class 数组中等差递增子区间的个数 {
    public static void main(String[] args) {

    }
    public static int numberOfArithmeticSlices(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int [] dp=new int[A.length];
        for (int i = 2; i <A.length ; i++) {
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i]=dp[i-1]+1;
            }
        }
        int res=0;
        for (int i:dp) {
            res+=i;
        }
        return res;
    }
}
