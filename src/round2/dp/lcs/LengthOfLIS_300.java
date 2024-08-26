package round2.dp.lcs;

import java.util.Arrays;

public class LengthOfLIS_300 {
    /*
        最长递增子序列
        找到数组中严格递增子序列的长度
        1. dp 数组定义:
            dp[i]: 以 nums[i] 结尾的最长递增子序列的长度
        2. 递推公式
            当 nums[i] > nums[j] 时有
            dp[i] = Math.max(dp[i], dp[j] + 1)
        3. 初始化
            每个 nums[i] 结尾的最长递增子序列的长度至少为 1
        4. 遍历顺序
            从左到右
     */
    public int lengthOfLIS(int[] nums) {
        // 初始化 dp 数组
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
