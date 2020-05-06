package study.排序;

public class 按颜色进行排序 {
    public static void main(String[] args) {
        int []res=new 按颜色进行排序().sortColors(new int[]{2,0,2,1,1,0,2,1,0,0,2,1,1,2,1,2,0,0,1,0,1,0,1,0});
        for (int i:res) {
            System.out.println(i);
        }
    }
    public int[] sortColors(int[] nums) {
        int zero=0,one=0,two=nums.length-1;
        for (int i = 0; i <nums.length&&i<=two; i++) {
            if(nums[i]==0){
                swap(nums,i,zero++);
            }else if(nums[i]==2){
                swap(nums,i,two--);
                i--;
            }
        }
        return nums;
    }
    public void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
