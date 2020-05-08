package study.动态规划;

public class 区域和检索 {
    private int []sums;
    public 区域和检索(int[] nums) {
        int sum=0;
        sums=new int[nums.length+1];
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            sums[i+1]=sum;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i];
    }
}
