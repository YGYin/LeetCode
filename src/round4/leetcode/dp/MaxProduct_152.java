package round4.leetcode.dp;

public class MaxProduct_152 {
    /*
        乘积最大子数组
        用例最后保证是 32 位整数，不用开 long
        1. 开两个 dp 数组
            minDP[i]: 以 i 结束的最小乘积值
            maxDP[i]: 以 i 结束的最大乘积值
        2. 递推公式
            如果 nums[i] >= 0，照常取最大最小值
            如果 nums[i] < 0，最大值应该尝试取负数最小值与其相乘
                maxDP[i] = max(nums[i], nums[i]*minDP[i-1])
        3. 初始化
            minDP[0] = maxDP[0] = nums[0]
        4. 从左到右
     */
    public int maxProduct(int[] nums) {
        // 初始化 dp 数组
        int[] minDP = new int[nums.length];
        int[] maxDP = new int[nums.length];
        minDP[0] = nums[0];
        maxDP[0] = nums[0];

        int res = nums[0];
        // 遍历 dp 数组
        for (int i = 1; i < nums.length; i++) {
            // 如果当前数为正数，直接比较当前数和之前乘积取最大最小值
            if (nums[i] > 0) {
                minDP[i] = Math.min(nums[i], nums[i] * minDP[i - 1]);
                maxDP[i] = Math.max(nums[i], nums[i] * maxDP[i - 1]);
            }
            // 如果是负数，最大值应该和 minDP 最小值相乘，最小值应该和 maxDP 最大值相乘
            else {
                minDP[i] = Math.min(nums[i], nums[i] * maxDP[i - 1]);
                maxDP[i] = Math.max(nums[i], nums[i] * minDP[i - 1]);
            }
            // 记录全局最大值
            res = Math.max(res, maxDP[i]);
        }

        return res;
    }
}
