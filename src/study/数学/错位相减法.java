package study.数学;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class 错位相减法 {
    public static void main(String[] args) {
        System.out.println(最小公倍数(54,45));
//        LinkedHashMap
    }
    public static int 最大公约数(int a,int b){
        while (a-b!=0){
            if(a>b){
                int temp=a-b;
                a=Math.max(temp,b);
                b=Math.min(b,temp);
            }else {
                int temp=b-a;
                a=Math.max(temp,a);
                b=Math.min(a,temp);
            }
        }
        return b;
    }
    public static int 最小公倍数(int a,int b){
        int tempa=a,tempb=b;
        while (a-b!=0){
            if(a>b){
                int temp=a-b;
                a=Math.max(temp,b);
                b=Math.min(b,temp);
            }else {
                int temp=b-a;
                a=Math.max(temp,a);
                b=Math.min(a,temp);
            }
        }
        return tempa*tempb/b;
    }
}
