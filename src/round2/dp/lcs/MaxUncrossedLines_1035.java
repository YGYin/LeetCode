package round2.dp.lcs;

public class MaxUncrossedLines_1035 {
    /*
        不相交的线
        本质上就为最长公共子序列(不连续)
        1. dp[i][j]: 长度为[0, i-1]和[0, j-1] 的最长公共子序列的长度
        2. 递推公式:
            当 nums1[i-1] 和 nums[j-1] 相等时
                dp[i][j] = dp[i-1][j-1] + 1
            当不相等时，查看 nums1[i-1] 与 nums[j-2] 以及 nums1[i-2] 和 nums[j-1] 的最长公共子序列
                dp[i][j] = max(dp[i][j-1], dp[i-1][j])
        3. 初始化
            dp[i][0] = dp[0][j] = 0
        4. 从左到右，从上到下
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 初始化 dp 数组
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        // 遍历 dp 数组
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
