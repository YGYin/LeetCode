package round2.dp.bag01;

public class LastStoneWeightII_1049 {
    /*
        最后一块石头的重量 II
        从序列中选择子序列使得和接近 target 系列的题目，一般都是双向 dfs 或者 01 背包问题来完成
        本题其实就是尽量让石头分成重量相同的两堆(sum/2)，相撞之后剩下的石头最小，化解成01背包问题
        和分割等和子集几乎相同
        背包容量则为 sum / 2，物品的重量和价值都为 stones[i]
        1. dp[j]: 背包容量为 j 时的最大价值
        2. 递推公式:
            dp[j] = max(dp[j], dp[j - weight[i]) + val[i]
        3. 初始化: 一维 dp 数组可以全初始化为 0
        4. 遍历顺序: 先物品后背包，从后往前遍历（如果一维从前往后相当于变为完全背包问题）
     */
    public int lastStoneWeightII(int[] stones) {
        // 计算数组和
        int sum = 0;
        for (int i = 0; i < stones.length; i++)
            sum += stones[i];

        int target = sum / 2;
        // 初始化 dp 数组
        int[] dp = new int[target + 1];
        // 先物品后背包
        for (int i = 0; i < stones.length; i++)
            // 遍历背包要倒序，容量大于当前物品时有价值
            for (int j = target; j >= stones[i]; j--)
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);

        // dp[target] 为分出来的其中一堆石头，sum - dp[target] 则为另一堆石头
        // 因为 dp[target] 向下取整，所以 dp[target] <= sum - dp[target]
        // 让两堆石头相撞消消乐，剩下则为最小的可能重量
        return (sum - dp[target]) - dp[target];
    }
}
