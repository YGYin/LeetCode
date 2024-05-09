package round1.hot100.dp;

public class ClimbStairs_70 {
    public int climbStairs(int n) {
        /*
            爬楼梯
            1. dp[i]: 到达第 i 阶楼梯有 dp[i] 种方法
            2. 递推公式: 因为到达第 i 阶楼梯的方法数依赖于前两阶(只能通过前两阶到达)
                        dp[i] = dp[i - 1] + dp[i - 2]
            3. dp 数组初始化:
                    注意一个问题！斐波那契数列初始化 dp[0] = 0
                    但是此处 dp[0] 没有实际意义，因为到达第 0 阶台阶相当于没有移动，没有实际方法数
                    定义 dp[0] = 1 只是方便满足递推公式
            4. 遍历顺序: 从前往后
            5. 打印 dp 数组
         */

        // 特判处理边界条件
        if (n < 2)
            return n;
        // 已知 dp 递推公式，定义 dp 数组并初始化
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }
}
