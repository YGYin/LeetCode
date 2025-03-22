package round4.leetcode.dp.lts;

import java.util.Arrays;

public class FindLengthOfLCIS_674 {
    /*
        最长连续递增子序列
        1. dp[i]: 以 i 结尾的最长连续递增子序列
        2. if (nums[i] > nums[i-1])
                dp[i] = dp[i-1] + 1
           需要在每次循环中记录全局最大值
        3. 初始化为 1
        4. 从左到右
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
