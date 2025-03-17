package round4.leetcode.dp;

import java.util.Arrays;

public class NumSquares_279 {
    /*
        完全平方数
        类似于完全背包，n 为背包容量，完全平方数为商品，每个的重量为 i * i
        问装满背包的最少数量
        1. dp[j]: 装满容量为 j 的背包最少要 dp[j] 个完全平方数
        2. dp[j] = min(dp[j], dp[j - i * i] + 1)
        3. 初始化: dp[0] = 0; 其他为 MAX_VALUE
        4. 从左到右
     */
    public int numSquares(int n) {
        // 初始化 dp 数组
        int[] dp = new int[n + 1];
        // 求最小值，除 0 外其他为 MaxVal
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        // 遍历 dp 数组，先物品后背包
        // 因为存在完全平方数 1，所以一定能够将一个数分解为多个完全平方数
        for (int i = 1; i * i <= n; i++)
            for (int j = i * i; j <= n; j++)
                if (dp[j - i * i] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);

        // 不需要额外判断 dp[n] 是否为 Integer.MAX_VALUE
        return dp[n];
    }
}
