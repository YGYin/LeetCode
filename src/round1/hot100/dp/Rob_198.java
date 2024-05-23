package round1.hot100.dp;

public class Rob_198 {
    public int rob(int[] nums) {
        /*
            打家劫舍
            当前这个房间能不能偷取决于前两个房间是否被偷
            1. dp[i] 表示下表为 i 时所能偷到的最大金额数量
            2. 递推公式:
                - 考虑偷 i: dp[i - 2] + nums[i]，i - 1 相邻不能偷
                - 考虑不偷 i: dp[i - 1]，不偷 i 取 dp[i - 1]
                dp[i] = max(考虑偷 i, 考虑不偷 i)
            3. 初始化:
                需要初始化 dp[0] 和 dp[1] (需要判断 nums 是否长度只为 1)
                dp[0] = nums[0], dp[1] = max(nums[0], nums[1])
            4. 遍历顺序: 从左到右
         */
        // 特判
        if (nums.length == 1)
            return nums[0];
        // 初始化 dp 数组，因为定义的 i 为数组下标，返回的为 dp[len - 1]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 遍历 dp 数组，从左到右
        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        return dp[nums.length - 1];
    }
}
