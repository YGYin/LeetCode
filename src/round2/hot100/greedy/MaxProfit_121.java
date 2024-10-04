package round2.hot100.greedy;

public class MaxProfit_121 {
    /*
        买卖股票的最佳时机 I
        只能买卖一次，贪最低价格，每天尝试更新最低成本和最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int maxProfit = 0;
        int minCost = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 尝试今天卖出
            maxProfit = Math.max(maxProfit, prices[i] - minCost);
            // 贪最低成本
            minCost = Math.min(minCost, prices[i]);
        }
        return maxProfit;
    }
}
