package round1.hot100.dp;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        /*
            零钱兑换 1: 求凑成总金额的最少硬币数
            总金额 -> 背包容量  coins -> 物品重量  价格为硬币数量
            1. dp[j]: 在装满总金额为 j 的背包所需的最少硬币数
            2. 递推公式:
                min(不取硬币 i 和取硬币 i)
                dp[j] = min(dp[j], dp[j - coins[i]] + 1)
            3. 初始化:
                dp[0] = 0, 非零初始化为 Integer.MaxValue
            4. 遍历顺序:
                完全背包问题，非组合非排列，先物品先背包都可
                完全背包一维数组遍历背包时顺序遍历
         */
        // 初始化一维 dp 数组，因为求 dp[amount]，大小为 amount + 1
        int[] dp = new int[amount + 1];

        for (int j = 0; j < dp.length; j++)
            dp[j] = Integer.MAX_VALUE;
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;

        // 遍历 dp 数组，先物品后背包
        for (int i = 0; i < coins.length; i++)
            //正序遍历：完全背包每个硬币可以选择多次
            for (int j = coins[i]; j <= amount; j++)
                // 只有选择 i 物品时 dp[j - coins[i]] 不为初始最大值才有选择必要
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    // dp[j - coins[i]] 含义为不选 i 时的背包重量所能凑成 j - coins[i] 金额的最小硬币数
                    // 在此基础上 + 1 则为选择了 i 之后所能凑成金额为 j 的最小硬币数
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

        // 有可能没办法凑成 amount，需要判断
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
