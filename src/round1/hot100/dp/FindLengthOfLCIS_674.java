package round1.hot100.dp;

import java.util.Arrays;

public class FindLengthOfLCIS_674 {
    public int findLengthOfLCIS(int[] nums) {
        /*
            最大连续递增的子数组：数组中乘积最大的非空连续子数组
            1. dp[i]: 下标为 i 结尾时的最长连续递增序列的长度
            2. 递推公式:
                连续体现在只需要 i 和 i - 1 作比较，
                不需要 j 来遍历和 [0, i - 1] 全部元素都做一遍比较
                if(nums[i] > nums[i - 1])
                    dp[i] = dp[i - 1] + 1
            3. 初始化:
                所有元素本身都为一个长度为 1 的子序列
                dp[all] = 1
            4. 遍历顺序:
                从左到右
         */
        // 特判
        if (nums.length == 1)
            return 1;

        // 初始化 dp 数组
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // 用 resLen 记录当前最长连续递增子序列的长度
        int resLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
            resLen = Math.max(resLen, dp[i]);
        }

        return resLen;
    }
}
