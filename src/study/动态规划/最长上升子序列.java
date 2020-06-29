package study.动态规划;

import java.util.Arrays;

public class 最长上升子序列 {
    public static void main(String[] args) {
        System.out.println(new 最长上升子序列().lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        if(len<2){
            return len;
        }
        int []dp=new int[len];
        dp[0]=1;
        for (int i = 1; i <len ; i++) {
            int max=dp[0];
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
}
