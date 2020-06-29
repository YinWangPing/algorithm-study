package study.排序;

import java.util.Arrays;

public class 数组中第K大的元素 {
    public static void main(String[] args) {
        数组中第K大的元素 object = new 数组中第K大的元素();
        System.out.println(object.findKthLargest(new int[]{2, 1, 6, 4, 3, 2, 8, 9, 1, 1}, 4));
    }

    //    public int findKthLargest(int[] nums, int k) {
//        int []knums= Arrays.copyOf(nums,k);
//        for (int i = k/2-1; i >=0 ; i--) {
//            adjustHeap(knums,i,k);
//        }
//        for (int i = k; i <nums.length ; i++) {
//            if(nums[i]>knums[0]){
//                knums[0]=nums[i];
//            }
//            adjustHeap(knums,0,k);
//        }
//        return knums[0];
//    }
//    public void adjustHeap(int []nums,int i,int len){
//        int min=i;
//        if(i*2+1<len&&nums[i*2+1]<nums[min]){
//            min=i*2+1;
//        }
//        if(i*2+2<len&&nums[i*2+2]<nums[min]){
//            min=i*2+2;
//        }
//        if(min!=i){
//            swap(nums,i,min);
//            adjustHeap(nums,min,len);
//        }
//    }
//    public void swap(int []nums,int i,int j){
//        int temp=nums[i];
//        nums[i]=nums[j];
//        nums[j]=temp;
//    }
    public int findKthLargest(int[] nums, int k) {
        if(nums.length<k){
            return -1;
        }
        int [] keys=Arrays.copyOf(nums,k);
        for (int i = k/2-1; i >=0 ; i--) {
            adjustHeap(keys,i,k);
        }
        for (int i = k; i <nums.length ; i++) {
            if(nums[i]>keys[0]){
                keys[0]=nums[i];
                adjustHeap(keys,0,k);
            }
        }
        return keys[0];
    }
    public void adjustHeap(int []nums,int i,int len){
        int min=i;
        if(i*2+1<len&&nums[i*2+1]<nums[min]){
            min=i*2+1;
        }
        if(2*i+2<len&&nums[i*2+2]<nums[min]){
            min=i*2+2;
        }
        if(min!=i){
            swap(nums,i,min);
            adjustHeap(nums,min,len);
        }
    }
    public void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
