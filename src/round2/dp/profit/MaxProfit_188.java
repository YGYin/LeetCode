package round2.dp.profit;

public class MaxProfit_188 {
    /*
        买卖股票的最佳时机 IV
        III 为最多买卖 2 次，所以一共有 4 种状态，分别为第一次以及第二次持有或卖出
        那么买卖 k 次则变成有 2k 种状态，为第 k 次持有或者卖出
        相当于在 III 的基础上套个循环来更新每次持有和卖出的状态
        1. dp 数组含义
            关注两个状态，0: 没有任何操作  1: 持有  2: 不持有
            dp[i][j]: 在第 i 天时没有操作
            dp[i][j + 1]: 在第 i 天时为第 (j / 2) k 次持有状态
            dp[i][j + 2]: 在第 i 天时为第 (j / 2) k 次不持有状态

        2. 递推公式
            for(int j = 0; j < 2k; j += 2) {
                // 持有
                dp[i][j + 1] = max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i])
                // 卖出
                dp[i][j + 2} = max(dp[i - 1][j + 2], dp[i - 2][j + 1] - prices[i])
            }

        3. 初始化
            dp[prices.length][2k + 1],
            dp[0][j] j 为单数的时候为持有状态，初始化为 -prices[0]
        4. 遍历方向: 从左到右
     */
    public int maxProfit(int k, int[] prices) {
        // prices 长度至少为 1
        if (prices.length == 1)
            return 0;

        // 初始化 dp 数组
        int[][] dp = new int[prices.length][2 * k + 1];
        // 对于 j 为奇数即持有的状态初始化，第 0 天持有的利益为 -prices[i]
        for (int j = 1; j < 2 * k; j += 2)
            dp[0][j] = -prices[0];

        // 遍历 dp 数组
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                // 持有状态 = max(延续昨天的持有状态, 在昨天未操作或上一状态下今天买入股票)
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                // 不持有状态 = max(延续昨天不持有的状态, 在昨天持有状态下今天卖出股票)
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }

        return dp[prices.length - 1][2 * k];
    }
}
