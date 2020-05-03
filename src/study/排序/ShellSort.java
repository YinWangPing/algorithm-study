package study.排序;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 11:16
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 2, 3, 9, 1, 6, 2,1,5,3,10};
        int[] res = shellSort1(nums);
        for(int i:res){
            System.out.println(i);
        }
    }
    public static int [] shellSort(int []nums){
        int len=nums.length;
        for (int gap = len/2; gap >0 ; gap=gap/2) {
            for (int i = gap; i <len ; i=i+gap) {
                int key=nums[i],j;
                for (j = i; j -gap>=0&&nums[j-gap]>key ; j=j-gap) {
                    nums[j]=nums[j-gap];
                }
                nums[j]=key;
            }
        }
        return nums;
    }
    public static int [] shellSort1(int []nums){
        int len=nums.length;
        for(int gap=len/2;gap>0;gap=gap/2){
            for(int i=gap;i<len;i=i+gap){
                int key=nums[i],j;
                for(j=i;j-gap>=0&&nums[j-gap]>key;j=j-gap){
                    nums[j]=nums[j-gap];
                }
                nums[j]=key;
            }
        }
        return nums;
    }
}
