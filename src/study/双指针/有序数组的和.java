package study.双指针;

public class 有序数组的和 {
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        while (left<right){
            if(numbers[left]+numbers[right]<target){
                left++;
            }else if(numbers[left]+numbers[right]<target){
                right++;
            }else {
                return new int[]{left+1,right+1};
            }
        }
        return new int[]{};
    }
}
