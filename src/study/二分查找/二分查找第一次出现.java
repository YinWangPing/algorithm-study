package study.二分查找;

public class 二分查找第一次出现 {
    public static void main(String[] args) {
        System.out.println(new 二分查找第一次出现().binarySearchFirst(new int[]{1,2,3,3,4,4,4,5,6,7,8,8,9},4));
    }
    public int binarySearchFirst(int[] nums, int key) {
        int left=0,right=nums.length;//边界问题
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=key){
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return left;
    }
}
