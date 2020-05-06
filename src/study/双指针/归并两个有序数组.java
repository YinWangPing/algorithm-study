package study.双指针;

public class 归并两个有序数组 {
    public static void main(String[] args) {
        new 归并两个有序数组().merge(new int[]{1,2,3,4,0,0,0,0,0,0},4,new int[]{1,2,3,4,5,6},6);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=n+m-1;
        m=m-1;n=n-1;
        while (m>=0&&n>=0){
            if(nums1[m]>=nums2[n]){
                nums1[index--]=nums1[m];
                m--;
            }else {
                nums1[index--]=nums2[n];
                n--;
            }
        }
        while (n>=0){
            nums1[index--]=nums2[n--];
        }
    }
}
