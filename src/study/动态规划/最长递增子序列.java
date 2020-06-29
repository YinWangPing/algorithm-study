package study.动态规划;

/**
 * @description:给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: WangPingYin
 * @time: 2020/4/7 11:53
 */

public class 最长递增子序列 {
    public static void main(String[] args) {
        int []nums=new int[]{10,9,2,5,3,7,101,18};
//        System.out.println(lengthOfLIS(nums));
        System.out.println(maxLengthOfSubSequence1(nums));
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
    public static int maxLengthOfSubSequence(int [] nums){
        int len=nums.length;
        int []dp=new int[len];
        for (int i = 0; i <len ; i++) {
            int max=1;
            for (int j = 0; j <i ; j++) {
                if(nums[i]>nums[j]){
                    max=Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
        }
        int res=0;
        for (int i = 0; i <len ; i++) {
            if(dp[i]>res){
                res=dp[i];
            }
        }
        return res;
    }


    public static int maxLengthOfSubSequence1(int [] nums){
        int len=nums.length;
        if(nums==null||len==0){
            return 0;
        }
        int []dp=new int[len];
        for (int i = 1; i <len ; i++) {
            int max=1;
            for (int j = 0; j <i ; j++) {
                if(nums[i]>nums[j]){
                    max=Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
        }
        int res=dp[0];
        for (int i = 1; i <len ; i++) {
            if(res>dp[i]){
                res=dp[i];
            }
        }
        return res;
    }
}
