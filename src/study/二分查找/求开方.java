package study.二分查找;

public class 求开方 {
    public int mySqrt(int x) {
        if(x<1){
            return x;
        }
        int left=1,right=x-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            int sqrt=x/mid;
            if(mid==sqrt){
                return mid;
            }else if(mid>sqrt){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return right;
    }

}
