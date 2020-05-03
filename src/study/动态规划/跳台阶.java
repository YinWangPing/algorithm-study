package study.动态规划;

import java.util.Scanner;

/**
 * @description:跳台阶，每次跳一阶或两阶，跳n阶有多少种方法
 * @author: WangPingYin
 * @time: 2020/3/31 9:31
 */

public class 跳台阶 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()) {
            System.out.println(skipStep(scanner.nextInt()));
        }
    }
    public static int skipStep(int n){
        if(n<1){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        int pre1=2,pre2=1,res=0;
        for (int i = 3; i <=n ; i++) {
            res=pre1+pre2;
            pre2=pre1;
            pre1=res;
        }
        return res;
    }
}
