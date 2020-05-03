package study.排序;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 10:38
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 2, 3, 9, 1, 6, 2};
        int[] res = quickSort2(nums,0,nums.length-1);
        for(int i:res){
            System.out.println(i);
        }
    }
    public static int [] quickSort(int [] nums,int left,int right){
        if (left >= right) {
            return nums;
        }
        int i=left,j=right;
        int insert=nums[left];
        while (i<j){
            while (nums[j]>=insert&&i<j){
                j--;
            }
            while (nums[i]<=insert&&i<j ){
                i++;
            }
            if(i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left]=nums[i];
        nums[i]=insert;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
        return nums;
    }
    public static int [] quickSort1(int [] nums,int left,int right){
        if(left>=right){
            return nums;
        }
        int i=left,j=right,key=nums[left];
        while (i<j){
            while (nums[j]>=key&&i<j){
                j--;
            }
            while (nums[i]<=key&&i<j){
                i++;
            }
            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        nums[left]=nums[i];
        nums[i]=key;
        quickSort1(nums,left,i-1);
        quickSort1(nums,i+1,right);
        return nums;
    }
    public static int [] quickSort2(int [] nums,int left,int right){
        if(left>=right){
            return nums;
        }
        int i=left,j=right,key=nums[left];
        while(i<j){
            while(nums[j]>=key&&i<j){
                j--;
            }
            while(nums[i]<=key&&i<j){
                i++;
            }
            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        nums[left]=nums[i];
        nums[i]=key;
        quickSort2(nums,left,i-1);
        quickSort2(nums,i+1,right );
        return nums;
    }
}
