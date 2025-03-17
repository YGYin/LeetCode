package round4.leetcode.greedy;

public class MaxProfit_121 {
    /*
        买卖股票的最佳时机
        1. 只能在某一天买进，某一天卖出
        贪最高价卖出，贪最低价买入
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        // 定义当前最低价和最大利益
        int minCost = prices[0];
        int maxProfit = 0;
        // 从 1 开始遍历
        for (int i = 1; i < prices.length; i++) {
            // 尝试今天卖出更新最大利润
            maxProfit = Math.max(maxProfit, prices[i] - minCost);
            // 尝试今天买入更新最低价格
            minCost = Math.min(minCost, prices[i]);
        }

        return maxProfit;
    }
}
