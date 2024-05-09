package round1.dp;

public class Fib_509 {
    public int fib(int n) {
        /*
            1. dp[i] 代表第 i 个斐波那契数
            2. 递推公式：题目已给 dp[i] = dp[i - 1] + dp[i - 2]
            3. dp 数组初始化：题目已给 dp[0] = 1, dp[1] = 1;
            4. 遍历从前往后
            5. 打印 dp 数组 -> debug
         */
        // 边界处理，特判
        if (n < 2)
            return n;
        // 用一维 dp 数组储存斐波那契数列
        int[] dp = new int[n + 1];

        // 做 dp 数组初始化
        dp[0] = 0;
        dp[1] = 1;
        // 从 2 开始
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }
}
