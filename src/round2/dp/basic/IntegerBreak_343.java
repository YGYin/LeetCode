package round2.dp.basic;

public class IntegerBreak_343 {
    /*
        整数拆分
        1. dp[i]: 拆分 i，可以得到的最大乘积为 dp[i]
        2. 递推公式:
            i 可以被拆分成两个或两个以上的正整数
            i 拆成两个 -> dp[i] = j * (i - j)
            i 拆成或以上 -> dp[i] = j * dp[i - j]
            dp[i] = max(dp[i], j * (i - j), j * dp[i - j])
        3. 初始化:
            dp[0] dp[1] 无意义，dp[2] = 1
        4. 遍历顺序: 从小到大
     */
    public int integerBreak(int n) {
        // 初始化 dp 数组
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));

        return dp[n];
    }
}
