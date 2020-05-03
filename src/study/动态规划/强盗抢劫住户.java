package study.动态规划;

import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/31 9:42
 */

public class 强盗抢劫住户 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int len=scanner.nextInt();
            int[]nums=new int[len];
            for (int i = 0; i <len ; i++) {
                nums[i]=scanner.nextInt();
            }
            System.out.println(rob2(nums));
        }
    }
    /**
     *题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
     */
    public static int rob(int []nums){
        if(nums.length<1){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int pre1=nums[1],pre2=nums[0];
        for (int i = 2; i <nums.length ; i++) {
            int cur=Math.max(pre1,pre2+nums[i]);
            pre2=Math.max(pre1,pre2);//2,1,1,2
            pre1=cur;
        }
        return pre1;
    }
    public static int rob1(int []nums){
        int pre1=0,pre2=0;
        for (int i = 0; i <nums.length ; i++) {
            int cur=Math.max(pre1,pre2+nums[i]);
            pre2=pre1;//2,1,1,2
            pre1=cur;
        }
        return pre1;
    }
    /**
     *这个地方所有的房屋都围成一圈
     * 分成两部分0~len-1，1~len
     */
    public static int rob2(int[] nums) {
        if(nums.length<1){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(calculate(nums,0,nums.length-2),calculate(nums,1,nums.length-1));
    }
    public static int calculate(int[] nums,int left,int right) {
        if(right-left<0){
            return 0;
        }else if(right-left==0){
            return nums[left];
        }else if(right-left==1){
            return Math.max(nums[left],nums[left+1]);
        }
        int pre1=nums[left+1],pre2=nums[left];
        for (int i = left+2; i <=right ; i++) {
            int cur=Math.max(pre1,pre2+nums[i]);
            pre2=Math.max(pre1,pre2);//2,1,1,2
            pre1=cur;
        }
        return pre1;
    }
}
