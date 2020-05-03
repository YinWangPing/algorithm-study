package study.动态规划;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/4/5 21:56
 */

public class 矩阵中不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(10,10));
    }
    public static int uniquePaths(int m, int n) {
        if(m==0||n==0){
            return 0;
        }
        if(m==1||n==1){
            return 1;
        }
        long res = 1;
        for(int i=1;i<m;i++ ){
            res=res*(n-1+i)/i;
        }
        return (int) res;
    }
}
