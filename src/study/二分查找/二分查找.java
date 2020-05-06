package study.二分查找;

public class 二分查找 {
    public static void main(String[] args) {
        System.out.println(new 二分查找().binarySearch(new int[]{1,2,3,4,5,6,7,8,8,9},6));
    }
    public int binarySearch(int[] nums, int key) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==key){
                return mid;
            }else if(nums[mid]>key){
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return -1;
    }
}
