package study.Vivo;

import java.util.ArrayList;
import java.util.List;

public class 数位之积 {
    public static void main(String[] args) {
        System.out.println(solution(1024));
    }
    public static int solution (int n) {
        // write code here
//        List<Integer>res=new ArrayList<>();
        int res=0,count=1;
        for (int i = 9; i >1 ; i--) {
//            if(n<=9){
//                res+=n*count;
//                break;
//            }
            if (n%i==0){
                res+=i*count;
                count=count*10;
                n=n/i;
                i++;
            }
        }
        if(n>9){
            return -1;
        }else {
            return res;
        }
    }

    int solution2(int n) {
        // write code here
        if (n < 10) return 10 + n;
        int res = 0, base = 1;
        for (int i = 9; i > 1; i--) {
            while (n % i == 0) {
                res += i * base;
                base*=10;
                n /= i;
            }
        }
        if (n > 1) return -1;
        else return res;
    }
    public int solution1 (int n) {
        int res = recur(n);
        if (res > 0) return res;
        return -1;
    }

    public static int recur(int n) {
        if (n <= 9) return n;
        for (int i = 9; i > 1; i--) {
            if (n % i == 0) return recur(n/i)*10 + i;
        }
        return -1;
    }
}
