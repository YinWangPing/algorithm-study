package study.贪心;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/5/2 23:33
 */

public class 买卖股票的最佳时机_一次交易 {
    public static void main(String[] args) {
        int[]nums=new int[]{7,1,5,3,6,4};
        买卖股票的最佳时机_一次交易 o=new 买卖股票的最佳时机_一次交易();
        System.out.println(o.maxProfit(nums));
    }
    public int maxProfit(int[] prices) {
        int min=prices[0],maxprofit=0;
        for (int i = 1; i <prices.length ; i++) {
            maxprofit=Math.max(maxprofit,prices[i]-min);
            if(min>prices[i]){
                min=prices[i];
            }
        }
        return maxprofit;
    }
}
