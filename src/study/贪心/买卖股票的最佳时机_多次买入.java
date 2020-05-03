package study.贪心;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/5/2 23:40
 */

public class 买卖股票的最佳时机_多次买入 {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int res=0;
        for (int i = 1; i <prices.length ; i++) {
            if(prices[i]>prices[i-1]){
                res+=prices[i]-prices[i-1];
            }
        }
        return res;
    }
}
