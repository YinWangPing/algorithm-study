package study.排序;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 15:30
 */

public class CountSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 2, 3, 9, 1, 6, 2, 1, 5, 3, 10};
        int[] res = countSort(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public static int[] countSort(int []nums){
        int len=nums.length,min=nums[0],max=nums[0],index=0;
        if(len<2){
            return nums;
        }
        for (int i = 1; i <len ; i++) {
            if(nums[i]<min){
                min=nums[i];
            }
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int [] temp=new int[max-min+1];
        for (int i = 0; i <len; i++) {
            temp[nums[i]-min]++;
        }
        for (int i = 0; i <temp.length ; i++) {
            if(temp[i]!=0){
               while (temp[i]-->0){
                   nums[index++]=min+i;
               }
            }
        }
        return nums;
    }
}
