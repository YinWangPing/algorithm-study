package study.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * @author: WangPingYin
 * @time: 2020/2/13 10:42
 */

public class 数组中的重复数字 {
    public static void main(String[] args) {
        int [] nums=new int[]{2,3,5,3,2,4};
        System.out.println(isRepeat1(nums));
    }
    /**
     *使用list自带的contains方法实现
     */
    public static int isRepeat0(int []nums){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }else {
                return nums[i];
            }
        }
        return -1;
    }
    /**要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
     *对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
     * 本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
     */
    public static int isRepeat1(int []nums){
        int len=nums.length;
        if(len<=1){
            return -1;
        }
        for (int i = 0; i <len ; i++) {
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                swap(nums,nums[i],i);
            }
        }
        return -1;
    }
    public static void swap(int [] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
