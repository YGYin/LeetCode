package round2.dp.bag;

import java.util.Arrays;

public class CoinChange_322 {
    /*
        零钱兑换 硬币无限使用 -> 完全背包
        可以凑成总金额所需的 最少的硬币个数
        1. dp[j]: 可以凑成总金额为 j 所需的最少硬币个数
        2. 递推公式:
            因为凑成总金额为 j - coins[i] 的最少硬币个数为 dp[j - coins[i]]
            再加上一个硬币 coins[i] 则为 dp[j - coins[i]] + 1 能凑成总金额 j
            类似于选择该金币或者不选，不选则为 dp[j], 选则为 dp[j - weight[i]] + 1
            -> dp[j] = min(dp[j], dp[j - coins[i]] + 1);
        3. 初始化:
            因为金额为 0 时不需要硬币，所以 dp[0] = 0，
            但方便更新 dp 数组非 0 其它值应初始化为最大值，这样才不会在取 min 的时候被初始值所覆盖
        4. 遍历顺序:
            不强调是组合还是排列，默认先物品再背包
     */
    public int coinChange(int[] coins, int amount) {
        // 初始化 dp 数组
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 遍历 dp 数组 先物品
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 只有不是初始最大值时，才有选择意义
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
            System.out.println("dp: " + Arrays.toString(dp));
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange_322 test = new CoinChange_322();
        test.coinChange(new int[]{1, 2, 5}, 5);
    }
}
