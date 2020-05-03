package study.排序;

import java.util.ArrayList;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 16:34
 */

public class RadixSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 2, 3, 9, 1, 6, 2, 1, 5, 3, 10};
        int[] res = radixSort(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] radixSort(int[] nums) {
        int len = nums.length, max = nums[0];
        if (len < 2) {
            return nums;
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int maxDigix=0;
        while (max>0){
            maxDigix++;
            max=max/10;
        }
        ArrayList<ArrayList<Integer>> list=new ArrayList<>(10);
        for (int i = 0; i <10 ; i++) {
            list.add(new ArrayList<Integer>());
        }
        int mod=10,div=1;
        for (int i = 0; i <10 ; mod*=10,div*=10,i++) {
            for (int j = 0; j <len ; j++) {
                list.get((nums[j]%mod)/div).add(nums[j]);
            }
            int index=0;
            for (int j = 0; j <10 ; j++) {
                for (int k = 0; k <list.get(j).size() ; k++) {
                    nums[index++]=list.get(j).get(k);
                }
                list.get(j).clear();
            }
        }
        return nums;
    }
}
