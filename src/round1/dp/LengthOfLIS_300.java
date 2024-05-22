package round1.dp;

import java.util.Arrays;

public class LengthOfLIS_300 {
    public int lengthOfLIS(int[] nums) {
        /*
            最长递增子序列(非连续)
            1. dp[i] 表示以下标 i 结尾(包含 nums[i]) 的最长递增子序列的长度
            2. 递推公式:
                当 i > j 时，如果 nums[i] > nums[j] 则为递增子序列，长度 + 1
                dp[i] = max(dp[i], dp[j] + 1)
            3. 初始化:
                因为表示以下标 i 结尾的子序列长度，每个元素单独就为一个长度为 1 的子序列
                所以 dp[all] = 1
            4. 遍历顺序
                从左到右
         */
        // 初始化 dp 数组
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int resLen = 1;

        // 遍历 dp 数组，从左到右，i 从 1 开始，dp[0] 一定为 1
        for (int i = 1; i < nums.length; i++) {
            // 遍历 i 后面的 [0, i - 1] 所有情况
            for (int j = 0; j < i; j++)
                // i > j，nums[i] > nums[j]
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            // 因为最大子序列长度不一定为 dp[nums.length - 1]
            // 需要在所有 dp[i] 里面取最大值
            resLen = Math.max(resLen, dp[i]);
        }

        return resLen;
    }
}
