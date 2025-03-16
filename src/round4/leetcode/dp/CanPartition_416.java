package round4.leetcode.dp;

public class CanPartition_416 {
    /*
        分割等和子集
        本质为 01 背包问题，容量为 总和 / 2，重量刚好同时也为价值
        也就是求最后是否 dp[target] == target
        1. dp[j]: 当容量为 j 时，最大价值为 dp[j]
        2. dp[j] = max(dp[j], dp[j - nums[i]] + nums[i])
        3. dp[0] = 0
        4. 从左到右
     */
    public boolean canPartition(int[] nums) {
        // 先求和
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        // 分割等和子集，如果和不能被 2 整除可直接返回 false，target 为 sum / 2
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        // 初始化 dp 数组
        int[] dp = new int[target + 1];
        // 先物品后背包
        for (int i = 0; i < nums.length; i++)
            // 背包倒序遍历，确保更新不会被覆盖
            for (int j = target; j >= nums[i]; j--)
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);

        // 最后看是否能满足 dp[target] = target
        return dp[target] == target;
    }
}
