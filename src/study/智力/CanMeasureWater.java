package study.智力;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/21 11:30
 */

public class CanMeasureWater {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(1,1,12));
    }
    public static boolean canMeasureWater(int x, int y, int z) {
        if(z==0){
            return true;
        }else if(x==0&&y!=0&&z%y==0){
            return true;
        }else if(x==0&&y!=0&&z%y!=0){
            return false;
        }else if(y==0&&x!=0&&z%x==0){
            return true;
        }else if(y==0&&x!=0&&z%x!=0){
            return false;
        }else if(x==0&&y==0){
            return false;
        }
        if(z%gcd(x,y)==0){
            return true;
        }
        return false;
    }
    public static int gcd(int a,int b){
        if(a<b){
            gcd(b,a);
        }
        int c=a%b;
        // if(c==0){
        //     return b;
        // }
        while(c!=0){
            a=b;
            b=c;
            c=a%b;
        }
        return b;
    }
}
