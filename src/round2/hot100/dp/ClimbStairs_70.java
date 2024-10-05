package round2.hot100.dp;

public class ClimbStairs_70 {
    public int climbStairs(int n) {
        /*
            1. dp[i] 为到达 i 阶有 dp[i] 种方法
            2. dp[i] = dp[i-1] + dp[i-2]
            3. dp[0] = 0; dp[1] = 1; dp[2] = 2;
            4. 从左到右
         */
        if (n == 1)
            return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }
}
