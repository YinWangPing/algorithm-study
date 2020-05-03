package study.排序;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 11:40
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 2, 3, 9, 1, 6, 2,1,5,3,10};
        int[] res = mergeSort(nums,0,nums.length-1);
        for(int i:res){
            System.out.println(i);
        }
    }
    public static int [] mergeSort(int []nums,int left,int right){
        if(left<right) {
            int mid = (right + left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            return merge(nums, left, mid, right);
        }
        return nums;
    }
    public static int [] merge(int []nums,int left,int mid,int right){
        if(left>=right){
            return nums;
        }
        int []temp=new int[right-left+1];
        int i=left,j=mid+1,index=0;
        while (i<=mid&&j<=right){
            if(nums[i]<=nums[j]){
                temp[index++]=nums[i++];
            }else {
                temp[index++]=nums[j++];
            }
        }
        while (i<=mid){
            temp[index++]=nums[i++];
        }
        while (j<=right){
            temp[index++]=nums[j++];
        }
        for (int k = 0; k <right-left+1 ; k++) {
            nums[left+k]=temp[k];
        }
        return nums;
    }
}
