package round2.dp;

public class MaxProfit_123 {
    /*
       买卖股票的最佳时机 III
       要求可以对同一个股票进行两次买卖，求最后的最大利益，可以根据操作定义五种状态的 dp 数组
       1. dp 数组定义一共有 5 种状态
          在第 i 天
            dp[i][0]: 不操作
            dp[i][1]: 第一次持有该股票的状态，为可持续的状态，不一定为在第 i 天第一次买该股票
            dp[i][2]: 第一次不持有该股票的状态
            dp[i][3]: 第二次持有该股票的状态
            dp[i][4]: 第二次不持有该股票的状态
       2. 递推数组
            第 i 天状态都可以由 i - 1 的状态推导而来
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = max(延续前一天第一次持有的状态，或者之前没持有在今天买入)
            dp[i][2] = max(延续前一天第一次不持有的状态，或者之前第一次持有在今天卖出)
            dp[i][3] = max(延续前一天第二次持有的状态，或者之前第一次卖出后在今天第二次买入)
            dp[i][4] = max(延续前一天第二次不持有的状态，或者之前第二次持有在今天第二次卖出)
        3. 初始化
            无操作: dp[0][0] = 0
            第 0 天当天买入: dp[0][1] = dp[0][3] = -price[i]
            第 0 天当天卖出: dp[0][2] = dp[0][4] = 0
        4. 遍历顺序
            i - 1 -> i  从左往右，从上到下
            最后返回的为 dp[price.length - 1][4]，第二次卖出的状态已经包含了第一次卖出的最大利润
     */

    public int maxProfit(int[] prices) {
        // 数组长度最短为 1
        if (prices.length == 1)
            return 0;

        // 初始化 dp 数组
        int[][] dp = new int[prices.length][5];
        // 第 0 天买入
        dp[0][1] = dp[0][3] = -prices[0];

        // 遍历 dp 数组，从 1 开始
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            // 第一次持有，延续状态或者今天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 第一次不持有
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            // 第二次持有
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            // 第二次不持有
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[prices.length - 1][4];
    }
}
