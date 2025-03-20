package round4.leetcode.dp;

public class MaxProfit_188 {
    /*
        买卖股票的最佳时机 IV
        可以进行 k 次买卖，相当于将每次买卖中持有和不持有状态(j+1, j+2)包含到循环中
        1. dp[i][j+]: 第 i 天在 j 次买卖的状态下的最大利润，每次买卖都含持有和不持有两个状态，数组大小为 2k + 1
        2. 递推公式
            0: 没有操作, 1: 第一次持有, 2: 第一次不持有, 3: 第二次持有, 4: 第二次不持有
            原来买卖两次的递推公式为
            dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = max(dp[i-1][2], dp[i-1][1] + prices[i])
            dp[i][3] = max(dp[i-1][3], dp[i-1][2] - prices[i])
            dp[i][4] = max(dp[i-1][4], dp[i-1][3] + prices[i])
            -> 每次指针移动 j + 2
            dp[i][j+1] = max(dp[i-1][j+1], dp[i-1][j] - prices[i])
            dp[i][j+2] = max(dp[i-1][j+2], dp[i-1][j+1] + prices[i])
        3. 初始化
            dp[0][0] = 0, dp[0][1] = -prices[0], dp[0][2] = 0, dp[0][3] = -prices[i], dp[0][4] = 0
        4. 从左到右

     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1)
            return 0;

        // 初始化 dp 数组
        int[][] dp = new int[prices.length][2 * k + 1];
        // 单数为持有状态，初始化 dp 数组中第 0 天持有(买入)股票
        for (int i = 1; i < 2 * k; i += 2)
            dp[0][i] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                // 持有，延续持有状态，或者在前一天不持有的状态下今天买入
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                // 不持有，延续不持有状态，或者在前一天持有的状态下今天卖出
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }

        return dp[prices.length - 1][2 * k];
    }
}
