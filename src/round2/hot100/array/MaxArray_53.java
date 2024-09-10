package round2.hot100.array;

public class MaxArray_53 {
    /*
     * 1. dp[i] 表示以 i 结尾的子数组的最大和为 dp[i]，需要 res 记录全局最大子数组和
     * 2. dp[i] 要么当前值加上之前最大的子数组和，要么取当前值
     * dp[i] = max(nums[i], dp[i-1] + nums[i])
     * 3. 初始化
     * dp[i] = nums[0]
     * 4. 从左到右遍历
     */
    public int maxSubArray(int[] nums) {
        // 初始化 dp 数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
