package round2.dp.lcs;

import java.util.Arrays;

public class FindLengthOfLCIS_674 {
    /*
        最长连续递增序列
        相较于最长子序列，该题需要连续递增
        1. dp[i]: 以 nums[i] 结尾并包含的最长连续递增序列长度为 i
        2. 递推公式:
            当 dp[i] > dp[i - 1] 时
            dp[i] = dp[i - 1] + 1
        3. 初始化
            每个递增序列的最短长度为 1
        4. 遍历顺序
            从左往右
     */
    public int findLengthOfLCIS(int[] nums) {
        // 初始化 dp 数组
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;
        // 遍历 dp 数组
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
