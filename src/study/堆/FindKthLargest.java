package study.堆;

import java.util.*;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/17 11:01
 */

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest2(nums, 4));
        System.out.println("----------------------");
        System.out.println(findKthLargest4(nums, 0,nums.length-1,4));
    }

    /**
     * study.排序
     */
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        return list.get(len - k);
    }

    /**
     * 大顶堆
     */
    public static int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    public static int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int[] heap = Arrays.copyOf(nums, k);
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(heap, i, k);
        }
        for (int i = k; i < len; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                adjustHeap(heap, 0, k);
            }
        }
        return heap[0];
    }

    public static int[] adjustHeap(int[] nums, int i, int len) {
        int max = i;
        if (i * 2 + 1 < len && nums[i * 2 + 1] < nums[max]) {
            max = i * 2 + 1;
        }
        if (i * 2 + 2 < len && nums[i * 2 + 2] < nums[max]) {
            max = i * 2 + 2;
        }
        if (max != i) {
            swap(nums, i, max);
            adjustHeap(nums, max, len);
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int findKthLargest3(int[] nums, int k) {
        // k是要求的第几大(从1开始计数),k-1即是数组中的序号(0开始计数)
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    public static int findKthLargest(int[] nums, int low, int high, int k) {
        int index = partition(nums, low, high, k);
        if (index == k)
            return nums[index];
        else if (index > k)
            return findKthLargest(nums, low, index - 1, k);
        else
            return findKthLargest(nums, index + 1, high, k);
    }

    // 同快排的partation,每次确定一个枢轴的位置,并返回其index
    // 找第k 大 的数就把数组按大->小排列
    private static int partition(int[] nums, int low, int high, int k) {
        int pivot = nums[low];

        while (low < high) {
            while (low < high && nums[high] <= pivot) // nums[high]<=pivot 体现出把数组按大->小排列
                high--;
            nums[low] = nums[high];

            while (low < high && nums[low] >= pivot)
                low++;
            nums[high] = nums[low];
        }

        nums[low] = pivot;
        return low;
    }

    //    public static int[] quickSort(int []nums,int left,int right){
////        if(left>=right){
////            return nums;
////        }
////        int i=left,j=right,key=nums[left];
////        while (i<j){
////            while (nums[j]<=key&&i<j){
////                j--;
////            }
////            while (nums[i]>=key&&i<j){
////                j++;
////            }
////            if(i<j){
////                int temp=nums[i];
////                nums[i]=nums[j];
////                nums[j]=temp;
////            }
////        }
////        nums[left]=nums[i];
////        nums[i]=key;
////        quickSort(nums,left,i-1);
////        quickSort(nums,i+1,right);
////        return nums;
////    }
    public static int findKthLargest4(int[] nums, int low, int high, int k) {
        int index = partition1(nums, low, high);
        if (index == k)
            return nums[index];
        else if (index > k)
            return findKthLargest4(nums, low, index - 1, k);
        else
            return findKthLargest4(nums, index + 1, high, k);
    }
    public static int partition1(int[] nums, int left, int right) {
        if (left >= right) {
            return left;
        }
        int i = left, j = right, key = nums[left];
        while (i < j) {
            while (nums[j] <= key && i < j) {
                j--;
            }
            while (nums[i] >= key && i < j) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = key;
        return i;
    }

}
