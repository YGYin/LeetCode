package round4.leetcode.dp.lts;

import java.util.Arrays;

public class LengthOfLIS_300 {
    /*
        最长递增子序列
        同一个数组内找不连续的最长递增子序列
        1. dp[i]: 以 i 结尾的的最长递增子序列的长度为 dp[i]
        2. dp[i]
            i > j 情况下
            if nums[i] > nums[j] -> dp[i] = max(dp[i], dp[j] + 1);
            因为 dp[nums.length - 1] 不一定最大，需要用 res 记录全局最大值
        3. 初始化
            dp[] 全部为 1
        4. 从左到右
    */
    public int lengthOfLIS(int[] nums) {
        // 初始化 dp 数组
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            // 更新记录 dp[i] 最大值
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
