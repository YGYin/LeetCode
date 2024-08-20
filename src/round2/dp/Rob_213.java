package round2.dp;

import java.util.Arrays;

public class Rob_213 {
    /*
        打家劫舍 II
        和打家劫舍相比，房屋围成环，考虑三种情况
        1. 去头去尾，只偷中间元素
        2. 去头，偷剩余元素
        3. 去尾，偷剩余元素
        因为情况 2 和 3 已经包含了 1，
        相当于分别在情况 2 和 3 套用打家劫舍 I 逻辑，取两者最大值
     */
    public int rob(int[] nums) {
        // 长度最小为 1 特判
        if (nums.length == 1)
            return nums[0];
        // 打家劫舍 I 的逻辑，分别应用情况 2 3
        int res1 = robbing(nums, 1, nums.length - 1);
        int res2 = robbing(nums, 0, nums.length - 2);

        return Math.max(res1, res2);
    }

    private int robbing(int[] nums, int start, int end) {
        // 特判左右边界
        if (start == end)
            return nums[start];

        // 初始化 dp 数组
        int[] dp = new int[end + 1];
        Arrays.fill(dp, 0);
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        return dp[end];
    }
}
