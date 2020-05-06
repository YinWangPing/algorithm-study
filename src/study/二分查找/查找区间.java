package study.二分查找;

public class 查找区间 {
    public static void main(String[] args) {
        System.out.println(new 查找区间().searchRange(new int[]{1},1));
    }
    public int[] searchRange(int[] nums, int target) {
        int l=binarySearch(nums,target),r=binarySearch(nums,target+1);
        if(l==nums.length||nums[l]!=target){
            return new int[]{-1,-1};
        }else if(l!=r) {
            return new int[]{l, r - 1};
        }else {
            return new int[]{l,r};
        }
    }
    public int binarySearch(int []nums,int target){
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
}
