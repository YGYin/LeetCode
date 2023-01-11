package ds_primer;

public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        // dp[i]: nums[i] 作为结尾的连续子数组的最大和
        int len = nums.length;
        if (len == 1)
            return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; ++i) {
            if (dp[i - 1] > 0)
                dp[i] = dp[i - 1] + nums[i];
            else
                dp[i] = nums[i];
        }

        int maxSum = dp[0];
        for (int i = 1; i < len; ++i)
            maxSum = Math.max(maxSum, dp[i]);

        return maxSum;
    }

    public int maxSubArray_2(int[] nums) {
        int dp = 0, len = nums.length;
        int maxSum = nums[0];
        for (int i = 0; i < len; ++i) {
            dp = Math.max(dp + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp);
        }
        return maxSum;
    }
}
