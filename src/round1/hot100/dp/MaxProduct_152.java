package round1.hot100.dp;

public class MaxProduct_152 {
    /*
        乘积最大子数组: 找出数组中乘积最大的非空连续子数组，需要连续
        1. dp[i] 为以下标 i 结尾的连续子序列乘积的最大值
        2. 递推公式:
            dp[i] = max(dp[i - 1] * nums[i], nums[i])
            以下标 i 结尾，即：乘积数组中 nums[i] 必须被选取!
            - 如果 nums[i] 是负数,
                dp[i - 1] 是正数的时候，越乘越小，
                dp[i - 1] 是负数的时候，越乘越大，
                于是我们可能就需要记录一下负数的那个最小数
            需要记录以 nums[i] 结尾的连续子序列乘积的最小值和最大值
            当 nums[i] >= 0 时
               maxDP[i] = max(nums[i], maxDP[i - 1] * nums[i])
               minDP[i] = min(nums[i], maxDP[i - 1] * nums[i])
            当 nums[i] < 0
               maxDP[i] = max(nums[i], minDP[i - 1] * nums[i])
               minDP[i] = min(nums[i], maxDP[i - 1] * nums[i])
        3. 初始化:
            需要初始化 maxDP[0] = minDP[0] = nums[0]，否则后面乘积为 0
        4. 遍历顺序: 从左到右
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // 初始化 dp 数组
        int[] minDP = new int[nums.length];
        int[] maxDP = new int[nums.length];
        minDP[0] = nums[0];
        maxDP[0] = nums[0];

        int res = nums[0];
        // 考虑 {2, -1, 3} 的情况
        for (int i = 1; i < nums.length; i++) {
            // 如果 nums[i] >= 0
            // 照常相乘取最大值
            if (nums[i] >= 0) {
                maxDP[i] = Math.max(nums[i], maxDP[i - 1] * nums[i]);
                minDP[i] = Math.min(nums[i], minDP[i - 1] * nums[i]);
            }
            // 如果当前 nums[i] < 0，最大值应该尝试取负数最小值与其相乘
            else {
                maxDP[i] = Math.max(nums[i], minDP[i - 1] * nums[i]);
                minDP[i] = Math.min(nums[i], maxDP[i - 1] * nums[i]);
            }
            res = Math.max(res, maxDP[i]);
        }

        return res;
    }
}
