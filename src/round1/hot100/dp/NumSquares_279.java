package round1.hot100.dp;

public class NumSquares_279 {
    public int numSquares(int n) {
        /*
            完全平方数: 给 n，看最少能用多少个完全平方数拼凑而成
            相当于给一个容量为 n 的背包，完全平方数为物品
            问装满这个背包最少要用多少个物品，与零钱兑换相同
            1. dp[j]: 装满容量为 j 的背包所用的最少物品数量
            2. 递推公式:
                    dp[j] = min(dp[j], dp[j - i * i] + 1)
            3. 初始化
                    dp[0] = 0, 非 0 初始化为 MAX_VALUE
            4. 遍历顺序
                    非组合非排列，正常先物品后背包
         */
        // 初始化 dp 数组
        int[] dp = new int[n + 1];
        for (int j = 0; j < dp.length; j++)
            dp[j] = Integer.MAX_VALUE;
        dp[0] = 0;
        // 先遍历物品，完全平方数从 1 开始
        for (int i = 1; i * i <= n; i++)
            for (int j = i * i; j <= n; j++)
                // 只有 dp[j - i * i] 不为初始化的 MAX_VALUE 时才有意义
                if (dp[j - (i * i)] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - (i * i)] + 1);

        return dp[n];
    }
}
