package round2.dp.profit;

public class MaxProfit_309 {
    /*
        买卖股票的最佳时机含冷冻期
        可以多次买卖一只股票，但是卖出股票后有一天冷却期才能再买入股票(1 天冷却)，不能参与多笔交易
        1. dp[i][j]: 表示在第 i 天的状态 j 下的最大利润，可以分为四种状态:
            dp[i][0]. 持有股票状态，可持续，可以从今天买入股票或者持续之前买入股票的状态
            dp[i][1]. 冷冻期当天以及持续冷冻期过后的不持有的状态
            dp[i][2]. 卖出，比较今天卖出和昨天卖出

        2. 递推公式:
            持续昨天持有的状态，或者在冷却期过后买入
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i]);
            冷却器或者持续之后的状态
            dp[i][1] = dp[i-1][1];
            // 比较昨天卖和今天卖的利益更
            dp[i][2] = max(dp[i-1][2], dp[i-1][0] + prices[i]);

        3. 初始化
            持有状态 dp[0][0] = -prices[i]
            冷冻期当天和持续冷冻期过后不持有的状态 dp[0][1] = 0
            当天卖出利益为 0 dp[0][2] = 0

     */
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;
        // 初始化 dp 数组
        int[][] dp = new int[prices.length][3];

        // 1: 持有状态  2: 冷冻期当天或者过后一直不持有的状态 3: 当天卖出的状态
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // max(前一天持有的状态，前一天是冷冻期今天买入)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 冷冻期和之后不持有的状态
            dp[i][1] = dp[i - 1][2];
            // 卖出
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][2];
    }
}
