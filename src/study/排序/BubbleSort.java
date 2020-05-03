package study.排序;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 9:42
 */

public class BubbleSort {
    public static void main(String[] args) {
        int [] nums=new int[]{5,7,2,3,9,1,6,2};
        int []res=bubbleSort(nums);
        for (int i:res) {
            System.out.println(i);
        }
    }
    public static int [] bubbleSort(int [] nums){
        int len=nums.length;
        for (int i = 1; i <len ; i++) {
            for (int j = 0; j <len-i ; j++) {
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
    public static int [] bubbleSort1(int []nums){
        int len=nums.length;
        for (int i = len-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
}
