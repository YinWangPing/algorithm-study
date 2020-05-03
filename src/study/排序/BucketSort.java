package study.排序;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 16:07
 */

public class BucketSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 2, 3, 9, 1, 6, 2, 1, 5, 3, 10};
        int[] res = bucketSort1(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public static int[] bucketSort(int[] nums) {
        int len=nums.length,min=nums[0],max=nums[0],index=0;
        if(len<2){
            return nums;
        }
        for (int i = 1; i <len ; i++) {
            if(nums[i]<min){
                min=nums[i];
            }
            if(nums[i]>min){
                max=nums[i];
            }
        }
        int size=(max-min)/len+1;
        ArrayList<ArrayList<Integer>> list=new ArrayList<>(size);
        for (int i = 0; i <size ; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i <len ; i++) {
            list.get((nums[i]-min)/len).add(nums[i]);
        }
        for (int i = 0; i <size ; i++) {
            Collections.sort(list.get(i));
        }
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <list.get(i).size() ; j++) {
                nums[index++]=list.get(i).get(j);
            }
        }
        return nums;
    }
    public static int[] bucketSort1(int[] nums) {
        int len=nums.length,min=nums[0],max=nums[1],index=0;
        if(len<2){
            return nums;
        }
        for (int i = 0; i <len; i++) {
            if(nums[i]<min){
                min=nums[i];
            }
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int size=(max-min)/len+1;
        ArrayList<ArrayList<Integer>>list=new ArrayList<ArrayList<Integer>>(size);
        for (int i = 0; i <size ; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i <len ; i++) {
            list.get((nums[i]-min)/len).add(nums[i]);
        }
        for (int i = 0; i <size ; i++) {
            Collections.sort(list.get(i));
        }
        for (int i = size-1; i >=0 ; i--) {
            for (int j = list.get(i).size(); j > 0; j--) {
                nums[index++]=list.get(i).get(j-1);
            }
        }
        return nums;
    }
}
