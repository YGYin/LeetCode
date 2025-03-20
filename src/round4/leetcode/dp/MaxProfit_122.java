package round4.leetcode.dp;

public class MaxProfit_122 {
    /*
     * 买卖股票的最佳时机 II
     * 可以在每天任意购买或者卖出股票
     * 求最大利润，类似于最大数组和，贪每天的正利润，利润小于 0 就不要
     */
    // public int maxProfit(int[] prices) {
    // if (prices.length <= 1)
    // return 0;

    // int profit = 0;
    // // 于最大子数组不同的是，不要求连续
    // // 大于 0 直接累加，小于 0 不需要重置当前利润
    // for (int i = 1; i < prices.length; i++)
    // if (prices[i] - prices[i - 1] > 0)
    // profit += prices[i] - prices[i - 1];

    // return profit;
    // }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        // 初始化 dp 数组
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
