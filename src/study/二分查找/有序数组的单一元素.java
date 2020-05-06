package study.二分查找;

public class 有序数组的单一元素 {
    public static void main(String[] args) {
        System.out.println(new 有序数组的单一元素().singleNonDuplicate1(new int[]{1,1,2,3,3,4,4,8,8}));
    }
    /*
     *位运算
     */
    public int singleNonDuplicate(int[] nums) {
        int res=0;
        for (int i:nums) {
            res^=i;
        }
        return res;
    }
    /*
     *二分查找1,1,2,3,3,4,4,8,8
     */
    public int singleNonDuplicate1(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(mid%2==1){
                mid--;
            }
            if(nums[mid]<nums[mid+1]){
                right=mid;
            }else {
                left=mid+2;
            }
        }
        return nums[left];
    }
}
