package round2.hot100.dp;

import java.util.Arrays;

public class NumSquares_279 {
    /*
        完全平方数
        类似于完全背包，n 为背包容量，完全平方数为商品，
        问装满背包的最少数量
        1. dp[j]: 装满容量为 j 的背包最少要 dp[j] 个完全平方数
        2. dp[j] = min(dp[j], dp[j - i * i] + 1)
        3. 初始化: dp[0] = 0; 其他为 MAX_VALUE
        4. 从左到右
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 完全背包，先物品后背包，然后顺序遍历
        for (int i = 1; i <= n; i++)
            for (int j = i * i; j <= n; j++)
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);

        return dp[n];
    }
}
