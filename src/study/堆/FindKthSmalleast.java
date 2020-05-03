package study.堆;

import java.util.Arrays;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/20 16:20
 */

public class FindKthSmalleast {
    public static void main(String[] args) {
        int [] nums=new int[]{0,1,1,2,4,4,1,3,3,2};
        new FindKthSmalleast().getLeastNumbers(nums,6);
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        int []heap= Arrays.copyOf(arr,k);
        for (int i = k/2-1; i >=0 ; i--) {
            adjustHeap(heap,i,k);
        }
        for (int i =k; i <arr.length ; i++) {
            if(arr[i]<heap[0]){
                heap[0]=arr[i];
            }
        }
        return heap;
    }
    public int[]adjustHeap(int []nums,int i,int len){
        int max=i;
        if(i*2+1<len&&nums[2*i+1]>nums[max]){
            max=2*i+1;
        }
        if(i*2+2<len&&nums[2*i+2]>nums[max]){
            max=2*i+2;
        }
        if(max!=i){
            swap(nums,i,max);
            adjustHeap(nums,max,len);
        }
        return nums;
    }
    public void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
