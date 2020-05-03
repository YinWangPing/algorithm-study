package study.股票;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/27 10:38
 */

public class MaxProfit3 {
    public static void main(String[] args) {
        int []nums=new int[]{7,1,5,3,6,4,6};
        System.out.println(maxProfit(nums,2));
    }
    public static int maxProfit(int[] prices,int k) {
        int[][] t = new int[k][2];
        for(int i = 0; i < k; ++i)
            t[i][0] = Integer.MIN_VALUE;
        for(int p : prices) {
            t[0][0] = Math.max(t[0][0], -p);
            t[0][1] = Math.max(t[0][1], t[0][0] + p);
            for(int i = 1; i < k; ++i) {
                t[i][0] = Math.max(t[i][0], t[i-1][1] - p);
                t[i][1] = Math.max(t[i][1], t[i][0] + p);
            }
        }
        return t[k-1][1];
    }
}
