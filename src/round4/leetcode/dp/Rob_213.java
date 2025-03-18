package round4.leetcode.dp;

public class Rob_213 {
    /*
        打家劫舍 II
        和 I 相同，主要区别数组变成环状，可以取两次范围做打家劫舍 I，去首元素，去尾元素，去两者最大值
        1. dp[i]: 以 i 结尾最大能偷到 dp[i]
        2. dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        3. dp[0] = nums[0], dp[1] = max(dp[0], nums[1])
        4. 从左到右遍历
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // 分别去尾元素和首元素偷一次，左闭右闭
        int first = doRob(nums, 0, nums.length - 2);
        int tail = doRob(nums, 1, nums.length - 1);

        return Math.max(first, tail);
    }

    private int doRob(int[] nums, int left, int right) {
        if (right - left < 1)
            return nums[left];

        // 初始化 dp 数组
        int[] dp = new int[right + 1];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(dp[left], nums[left + 1]);

        for (int i = left + 2; i <= right; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        return dp[right];
    }
}
