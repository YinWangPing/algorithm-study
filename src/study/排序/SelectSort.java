package study.排序;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 9:52
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 2, 3, 9, 1, 6, 2};
        int[] res = selecSort(nums);
        for(int i:res){
            System.out.println(i);
        }
    }
    public static int [] selecSort(int []nums){
        int len=nums.length;
        for (int i = 0; i <len-1 ; i++) {
            int min=i;
            for (int j = i+1; j <len ; j++) {
                if(nums[min]>nums[j]){
                    min=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[min];
            nums[min]=temp;
        }
        return nums;
    }
}
