package round2.dp.basic;

public class ClimbStairs_70 {
    /*
        爬楼梯
        1. dp[i]: 到达第 i 阶楼梯有 dp[i] 种方法
        2. 递推公式：
            到达当前楼梯一定从上一个楼梯或者上两阶楼梯到达
            dp[i] = dp[i - 1] + dp[i - 2]
        3. 初始化：
            dp[0] 类似与没有跳，dp[1] = 1, dp[2] = 2
        4. 从前往后遍历
     */
    public int climbStairs(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }
}
