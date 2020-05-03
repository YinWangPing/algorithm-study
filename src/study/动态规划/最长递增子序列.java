package study.动态规划;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/7 11:53
 */

public class 最长递增子序列 {
    public static void main(String[] args) {
        int []nums=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int []dp=new int [nums.length];
        for (int i = 0; i <nums.length; i++) {
            int max=1;
            for (int j = 0; j <i ; j++) {
                if(nums[i]>nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i]=max;
        }
//        Arrays.sort(dp);
//        int res=1;
//        for (int i = dp.length-1; i >0 ; i--) {
//            if(dp[i]==dp[i-1]){
//                res++;
//            }
//        }

        int res=0;
        for (int i = 0; i <nums.length ; i++) {
            if(dp[i]>res){
                res=dp[i];
            }
        }
        return res;
    }
}
