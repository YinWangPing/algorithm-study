package study.排序;

import java.util.Arrays;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 17:18
 */

public class TopKHeapSort {
    public static void main(String[] args) {
        int [] nums=new int[50];
        for (int i = 0; i <50 ; i++) {
            nums[i]= (int) (Math.random()*100);
        }
        int []heap= Arrays.copyOf(nums,10);
        for (int i = heap.length/2-1; i >=0 ; i--) {
            adjustHeap(heap,i,heap.length);
        }
        for (int i = 10; i <nums.length ; i++) {
            if(nums[i]>heap[0]){
                heap[0]=nums[i];
                adjustHeap(heap,0,heap.length);
            }
        }
        Arrays.sort(nums);
        for (int i = 40; i <50 ; i++) {
            System.out.print(String.format("%s\t",""+nums[i]));
        }
        Arrays.sort(heap);
        for (int i = 0; i <heap.length ; i++) {
            System.out.print(String.format("%s\t",""+heap[i]));
        }
    }
    public static int [] adjustHeap(int [] nums,int i,int len){
        int min=i;
        if(i*2+1<len&&nums[i*2+1]<nums[min]){
            min=i*2+1;
        }
        if(i*2+2<len&&nums[i*2+2]<nums[min]){
            min=i*2+2;
        }
        if(min!=i){
            swap(nums,min,i);
            adjustHeap(nums,min,len);
        }
        return nums;
    }
    public static void swap(int [] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    //-------------------------------------
}
