package study.排序;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 9:59
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 2, 3, 9, 1, 6, 2};
        int[] res = insertSort3(nums);
        for(int i:res){
            System.out.println(i);
        }
    }
    public static int [] insertSort(int [] nums){
        int len=nums.length;
        for (int i = 1; i <len ; i++) {
            for (int j = i; j >0 ; j--) {
                if(nums[j]<nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
        return nums;
    }
    public static int [] insertSort1(int [] nums){
        int len=nums.length;
        for (int i = 1; i <len ; i++) {
            int insert=nums[i],j;
            for ( j = i; j >0 ; j--) {
                if(nums[j-1]>insert){
                    nums[j]=nums[j-1];
                }else {
                    break;
                }
            }
            nums[j]=insert;
        }
        return nums;
    }
    public static int [] insertSort2(int [] nums){
        int len=nums.length;
        for (int i = 1; i <len ; i++) {
            int insert=nums[i],j;
            for (j = i; j >0&&nums[j-1]>insert ; j--) {
                nums[j]=nums[j-1];
            }
            nums[j]=insert;
        }
        return nums;
    }
    public static int [] insertSort3(int [] nums){
        int len=nums.length;
        for(int i=1;i<len;i++){
            int key=nums[i],j;
            for(j=i;j>0&&nums[j-1]>key;j--){
                nums[j]=nums[j-1];
            }
            nums[j]=key;
        }
        return nums;
    }
}
