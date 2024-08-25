package round2.dp.profit;

public class MaxProfit_714 {
    /*
        买卖股票的最佳时机含手续费
        可以多次买卖一只股票，只是每次卖出都收取手续费
        1. dp 状态数组含义
            同样有两种状态：1. 持有该股票  2. 不持有该股票
        2. 递推公式
            dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
            dp[i][2] = max(dp[i-1][2], dp[i-1][1] + prices[i] - fee)
        3. 初始化
            当天买入股票: dp[0][1] = - price[i]
        4. 递归顺序
            从左到右，从上到下
     */
    public int maxProfit(int[] prices, int fee) {
        // 长度最短为 1
        if (prices.length == 1)
            return 0;

        // 初始化 dp 数组
        int[][] dp = new int[prices.length][3];
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i] - fee);
        }

        return dp[prices.length - 1][2];
    }
}
