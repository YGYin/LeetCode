package round2.hot100.dp;

public class CanPartition_416 {
    /*
        分割等和子集
        本质为完全背包问题，容量为 总和 / 2，重量刚好同时也为价值
        也就是求最后是否 dp[target] == target
        1. dp[j]: 当容量为 j 时，最大价值为 dp[j]
        2. dp[j] = max(dp[j], dp[j - nums[i]] + nums[i])
        3. dp[0] = 0
        4. 从左到右
     */
    public boolean canPartition(int[] nums) {
        // 如果和为奇数则无法被平分
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        if (sum % 2 == 1)
            return false;
        int target = sum / 2;

        // 初始化 dp 数组
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++)
            for (int j = nums[i]; j <= target; j++)
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);

        return dp[target] == target;
    }
}