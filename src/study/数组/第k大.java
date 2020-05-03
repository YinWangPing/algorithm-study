package study.数组;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/16 17:18
 */

public class 第k大 {
    public static void main(String[] args) {

    }
    public int findKthLargest(int[] nums, int low, int high, int k) {
        int index = partition(nums, low, high);
        if (index == k)
            return nums[index];
        else if (index > k)
            return findKthLargest(nums, low, index - 1, k);
        else
            return findKthLargest(nums, index + 1, high, k);
    }
    public int partition(int[] nums, int left, int right) {
        if (left >= right) {
            return left;
        }
        int i = left, j = right, key = nums[left];
        while (i < j) {
            while (nums[j] <= key && i < j) {
                j--;
            }
            while (nums[i] >= key && i < j) {
                j++;
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
