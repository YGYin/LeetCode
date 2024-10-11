package round2.hot100.dp;

import java.util.Arrays;

public class CoinChange_322 {
    /*
        零钱兑换
        求凑成总金额的最小硬币个数，完全背包问题，背包容量为 j，商品重量为 coins[i]
        1. dp[j]: 装满 dp[j] 背包所需的最少硬币为 dp[j]
        2. dp[j] = min(dp[j], dp[j - coins[i]] + 1)
        3. dp[0] = 0; 其余默认初始化为最大值
        4. 从左到右
     */
    public int coinChange(int[] coins, int amount) {
        // 初始化 dp 数组
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= amount; j++)
                // 注意，只有 dp[j-coins[i]] 不是初始最大值时，才有选择比较的意义
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
