package round3.hot100.greedy;

public class MaxProfit_121 {
    /*
        买卖股票的最佳时机
        1. 只能在某一天买进，某一天卖出
        贪最低价买入，贪最高价卖出
     */
    public int maxProfit(int[] prices) {
        // 特判
        if (prices.length <= 1)
            return 0;

        int maxProfit = 0;
        int minCost = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 尝试今天卖出
            maxProfit = Math.max(maxProfit, prices[i] - minCost);
            // 贪最低价买入
            minCost = Math.min(minCost, prices[i]);
        }

        return maxProfit;
    }
}
