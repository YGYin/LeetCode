package round2.dp.bag;

import java.util.Arrays;

public class NumSquares_279 {
    /*
        完全平方数
        完全背包：完全平方数为物品，凑正整数 n 为背包，求凑成最少要多少个物品
        1. dp[j]: 凑成正整数 j 的完全平方数的最少数量为 dp[j]
        2. 递推公式:
            dp[j] = min(dp[j], dp[j - 平方数(i * i)] + 1)
        3. 初始化:
            dp[0] = 0，不需要完全平方数凑，其他下标应初始化为最大值
        4. 遍历顺序:
            求组合数，先物品后背包
     */
    public int numSquares(int n) {
        // 初始化 dp 数组
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 遍历 dp 数组，先物品后背包，完全平方数从 1 开始
        for (int i = 1; i * i <= n; i++)
            for (int j = i * i; j <= n; j++)
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);

        // 不需要判断 dp[n] 是否为初始值，因为完全平方数不会凑不成
        return dp[n];
    }
}
