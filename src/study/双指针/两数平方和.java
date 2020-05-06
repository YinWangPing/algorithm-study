package study.双指针;

public class 两数平方和 {
    public static void main(String[] args) {

    }
    public boolean judgeSquareSum(int c) {
        int right= (int) Math.sqrt(c);
        int left=0;
        while (left<=right){
            if(left*left+right*right<c){
                left++;
            }else if(left*left+right*right>c){
                right--;
            }else {
                return true;
            }
        }
        return false;
    }
}
