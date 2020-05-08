package study.动态规划;

public class 等差递增子区间个数 {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        if (A.length < 3) {
            return 0;
        }
        int res=0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res+=dp[i];
            }
        }
        return res;
    }
}
