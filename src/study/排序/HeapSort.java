package study.排序;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/14 12:13
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 2, 3, 9, 1, 6, 2, 1, 5, 3, 10};
        int[] res = heapSort(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public static int[] heapSort(int []nums) {
        int len=nums.length;
        if(len<2){
            return nums;
        }
        //从第一个非叶子节点开始调整堆结构,构建大顶堆或小顶堆；
        for (int i = len/2-1; i>=0 ; i--) {
            adjustHeap(nums,i,len);
        }
        //构建完成后第一个元素为最大值或最小值
        while (len>0){//将第一个最值与最后一个值互换，并重新调整堆结构
            swap(nums,0,len-1);
            len--;
            adjustHeap(nums,0,len);
        }
        return nums;
    }
    public static int [] adjustHeap(int []nums,int i,int len){
        int max=i;
        if(2*i+1<len&&nums[2*i+1]>nums[max]){//左子节点存在并大于max节点，max置为左子节点
            max=2*i+1;
        }
        if(2*i+2<len&&nums[2*i+2]>nums[max]){//右子节点存在并大于max节点，max置为右子节点
            max=2*i+2;
        }
        if(max!=i){//当max为左子节点或右子节点时将其与父节点交换，重新调整堆结构
            swap(nums,i,max);
            adjustHeap(nums,max,len);
        }
        return nums;
    }
    public static void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
