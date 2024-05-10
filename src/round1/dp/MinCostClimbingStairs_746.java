package round1.dp;

public class MinCostClimbingStairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        /*
            最小消耗爬楼梯，求到达楼顶的最小花费
            1. dp[i]: 到达 i 层所需要的花费为 dp[i]
            2. 递推公式: dp[i] 可以由 dp[i - 1] 和 dp[i - 2] 到达
                     到达 i 层花费为到达第 i - 1 层所需花费加上 i - 1 本身的 cost
                     -> dp[i] = min(
                                dp[i - 1] + cost[i - 1],
                                dp[i - 2] + cost[i - 2]
                                )
            3. dp 数组初始化
               需要初始化 dp[1] 和 dp[0]
            4. 遍历顺序: 从前向后
        */
        // 初始化 dp 数组
        int[] dp = new int[cost.length + 1];
        // 因为到达第 0 和 1 阶的时候不需要花费
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= cost.length; i++)
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);

        return dp[cost.length];
    }
}
