package round2.dp.basic;

public class MinCostClimbingStairs_746 {
    /*
        使用最小花费爬楼梯
        1. dp[i]: 到达第 i 阶楼梯所需的最小花费为 dp[i]
        2. 递推公式:
                当前楼梯只能从前一个或者前两个台阶到达
                从 dp[i - 1] 到达 dp[i] 的花费: dp[i - 1] + cost[i - 1]
                从 dp[i - 2] 到达 dp[i] 的花费: dp[i - 2] + cost[i - 2]
                -> dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        3. 初始化:
                因为可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯
                所以到达第 0 或 1 个台阶是不花费的，但向上跳需要花费 cost[0] 或 cost[1]
                -> dp[0] = dp[1] = 0;
        4. 遍历顺序:
                从前往后
     */
    public int minCostClimbingStairs(int[] cost) {
        // 定义 dp 数组
        int[] dp = new int[cost.length + 1];
        // 初始化
        dp[0] = 0;
        dp[1] = 0;

        // 遍历 cost 数组，dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        for (int i = 2; i <= cost.length; i++)
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);

        return dp[cost.length];
    }
}
