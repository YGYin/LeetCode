package round4.leetcode.dp;

public class Rob_198 {
    /*
        打家劫舍
        1. dp[i]: 以 i 为结尾所偷到的最大金额
        2. 递推公式
            要么不偷当前这家取 dp[i-1], 要么偷当前这家金额加上 dp[i-2]
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        3. dp[0] = nums[0], dp[1] = max(dp[0], nums[1])
        4. 从左到右
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // 初始化 dp 数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        return dp[nums.length - 1];
    }
}
