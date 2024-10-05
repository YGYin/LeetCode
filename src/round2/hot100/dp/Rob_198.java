package round2.hot100.dp;

public class Rob_198 {
    /*
        打家劫舍
        1. dp[i]: 以 i 为结尾所偷到的最大金额
        2. dp[i] = max(dp[i-2] + nums[i], dp[i-1])
        3. dp[0] = nums[0], dp[1] = max(dp[0], dp[1])
        4. 从左到右
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        return dp[nums.length - 1];
    }
}
