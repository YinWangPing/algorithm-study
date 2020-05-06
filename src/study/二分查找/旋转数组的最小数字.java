package study.二分查找;

public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        System.out.println(new 旋转数组的最小数字().findMin(new int[]{1,1,1,0,1}));
    }
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[right]){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return nums[left];
    }
}
