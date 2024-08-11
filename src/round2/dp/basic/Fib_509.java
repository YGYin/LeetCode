package round2.dp.basic;

public class Fib_509 {
    /*
        1. dp[i] 含义: 第 i 个数的斐波那契数为 dp[i]
        2. 递推公式：
             dp[i] = dp[i - 1] + dp[i - 2]
        3. 初始化: 初始化 dp[0] dp[1]
        4. 遍历顺序: dp2 依赖于 dp1 和 dp0，需要从签完后遍历
        5. 举例推导或者打印 debug
     */
    public int fib(int n) {
        // 特判
        if (n < 2)
            return n;
        // 初始化
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }
}
