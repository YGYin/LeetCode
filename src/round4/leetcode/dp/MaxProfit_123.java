package round4.leetcode.dp;

public class MaxProfit_123 {
    /*
        买卖股票的最佳时机 III
        最多买卖股票两次，可以定义 5 种操作
        0: 没有操作, 1: 第一次持有, 2: 第一次不持有, 3: 第二次持有, 4: 第二次不持有
        1. dp[i][]: 在第 i 天执行这 5 种操作的最大利润
        2. 递推公式: dp[i][0] 可以不处理，因为没有操作默认是 0 延续之前状态
            dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = max(dp[i-1][2], dp[i-1][1] + prices[i])
            dp[i][3] = max(dp[i-1][3], dp[i-1][2] - prices[i])
            dp[i][4] = max(dp[i-1][4], dp[i-1][3] + prices[i])
        3. 初始化
            dp[0][0] = 0, dp[0][1] = -prices[0], dp[0][2] = 0, dp[0][3] = -prices[i], dp[0][4] = 0
        4. 从左到右
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        // 初始化 dp 数组
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        // 遍历 dp 数组
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}
