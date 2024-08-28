package round2.dp;

public class MaxSubArray_53 {
    /*
        最大子数组和
        1. 贪心，当当前和为负数时重置为 0，每次更新最大和
        2. dp
            - dp[i]: 以 nums[i] 结尾的最大值数组和
            - 递推公式：
                dp[i] 从两个方向可以推出来
                1. 要么加上当前数字 dp[i-1] + nums[i]
                2. 要么从当前数字开始重新计数 nums[i]
                dp[i] = max(dp[i-1]+nums[i], nums[i])
             - 初始化
                dp[0] = nums[0]
             - 遍历顺序
                从左到右
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // 初始化 dp 数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int res = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int maxSubArrayGreedy(int[] nums) {
        // 贪心
        if (nums.length == 1)
            return nums[0];

        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            maxSum = Math.max(curSum, maxSum);
            // 如果当前和小于 0 则重置为 0
            if (curSum < 0)
                curSum = 0;
        }
        return maxSum;
    }
}
