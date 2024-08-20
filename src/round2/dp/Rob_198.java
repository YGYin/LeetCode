package round2.dp;

import java.util.Arrays;

public class Rob_198 {
    /*
        打家劫舍
        不能偷相邻的房屋，那要么偷第 i 家，要么偷 i - 1
        1. dp[i]: 考虑偷第 i 家的最高金额
        2. 递推公式:
            偷第 i 家: dp[i - 2] + nums[i] (保证之前偷的最大，加上当前第 i 家金额)
            偷第 i - 1 家: dp[i - 1]
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        3. 初始化:
            求最大，从左到右初始化为 0，dp[0] = nums[0]，dp[1] = max(nums[0], nums[1])
        4. 遍历顺序: 从左到右
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // 初始化 dp 数组
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 遍历 dp 数组
        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        return dp[nums.length - 1];
    }
}
