package study.Vivo;

public class 量产手机 {
    public static void main(String[] args) {
        System.out.println(solution1(11));
    }
    public static int solution (int n) {
        // write code here
        int res=0,count=0,index=1;
        while (count<n){
            for (int i = 0; i <index ; i++) {
                res+=index;
                count++;
                if(count==n){
                    return res;
                }
            }
            index++;
        }
        return res;
    }
    public static int solution1 (int n) {
        // write code here
        int res=0,i;
        for (i = 1; i*(i+1) <2*n ; i++) {
            res+=i*i;
        }
        int temp=i*(i-1)/2;
        while (temp<n){
            res+=i;
            temp++;
        }
       return res;
    }
}
