package round4.leetcode.dp.lts;

public class FindLength_718 {
    /*
        最长重复子数组
        求两个数组的公共连续子序列，用二维 dp 数组保存两个数组的比较状态
        1. dp[i][j]: 以 nums1[i-1], nums2[j-1] 结尾的最长重复子数组的长度
        2. 递推公式
            如果有 nums[i-1] == nums[j-1]
                dp[i][j] = dp[i-1][j-1] + 1
            因为求的是子数组连续子序列，所以是从 nums1[i-2] nums2[j-2] 推导而来
            同时需要在每次遍历时记录全局最大的重复子数组长度
        3. 初始化
            如果定义 dp[i][j] 为以 nums1[i], nums2[j] 结尾
                那么初始化时需要分别遍历 nums1 所有元素和 nums2[0] 比较是否相同
                    相同时令 dp[i][0] = 1
                还需遍历 nums2 所有元素和 nums1[0] 比较是否相同
                    相同时将令 dp[0][j] = 1

            而将 dp[i][j] 定义为以 nums1[i-1], nums2[j-1] 结尾是为了方便初始化，
            在该定义下，dp[0][j] 和 dp[i][0] 无意义，直接初始化为 0
            后续遍历到有相同的元素时直接在 dp[0][j] 和 dp[i][0] 基础上 + 1
        4. 遍历顺序: 从左到右 从上到下
     */
    public int findLength(int[] nums1, int[] nums2) {
        // 初始化 dp 数组
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
