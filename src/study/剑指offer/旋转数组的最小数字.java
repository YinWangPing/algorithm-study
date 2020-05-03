import java.util.HashMap;

/**
 * @description:旋转数组的最小数字
 * @author: WangPingYin
 * @time: 2020/2/14 15:56
 */
/*题目:
        把一个数组的最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个**递增排序【更准确的说法是 非递减排序， 本题目的难点就是需要考虑各种特殊情况】**的数组的一个旋转，输出旋转数组的最小元素。
        例如，study.数组 {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。*/
public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        int []nums0=new int[]{1,1,1,0,1};
        int []nums1=new int[]{1,0,1,1,1,1};
        System.out.println(minNumberInRotateArray(nums0));
        System.out.println(minNumberInRotateArray(nums1));
    }
    /**
     *mine
     */
    public static int minNumberInRotateArray(int [] array) {
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }
}
