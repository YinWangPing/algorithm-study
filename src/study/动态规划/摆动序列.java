package study.动态规划;

public class 摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len=nums.length,up=1,down=1;
        for (int i = 1; i <len ; i++) {
            if(nums[i]>nums[i-1]){
                up=down+1;
            }else if(nums[i]<nums[i-1]) {
                down=up+1;
            }
        }
        return Math.max(up,down);
    }
}
