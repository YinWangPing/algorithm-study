package study.二分查找;

public class 寻找比目标字母大的第一个字母 {
    public static void main(String[] args) {
        System.out.println(new 寻找比目标字母大的第一个字母().nextGreatestLetter(new char[]{'a','f','x','y'},'x'));
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int left=0,right=letters.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(letters[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        if(left==letters.length){
            return  letters[0];
        }else {
            return letters[left];
        }
    }
}
