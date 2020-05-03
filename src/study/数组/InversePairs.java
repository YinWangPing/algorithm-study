package study.数组;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/18 19:49
 */

public class InversePairs {
    public static void main(String[] args) {
        int [] nums=new int[]{1,2,3,4,5,6,7,0};
        System.out.println(inversePairs(nums));;
    }
    private static long cnt=0;
    public static int inversePairs(int []nums){
        cnt=0;
        mergeSort(nums,0,nums.length-1);
        return (int) (cnt%1000000007);
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
                cnt += mid - i + 1;
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
