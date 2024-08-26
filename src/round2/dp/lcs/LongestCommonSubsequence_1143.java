package round2.dp.lcs;

public class LongestCommonSubsequence_1143 {
    /*
        最长公共子序列
        和最长公共子数组相比，相同部分不需要连续
        1. dp[i][j]: 以 text1[i-1] 和 text2[j-1] 结尾的最长公共子序列的长度
        2. 递推公式:
            相比于最长公共子数组只需要关注相同的情况，最长公共子序列还需要关注当前不相同的情况
            如果相同 text1[i-1] == text2[j-1] 找到公共元素
                dp[i][j] = dp[i-1][j-1] + 1
            如果当前不相同 text1[i-1] != text2[j-1]，
            那就看 text1[i-2] 和 text2[j-1] 或 text1[i-1] 和 text2[j-2] 的最长公共子序列的长度
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        3. 初始化
            dp[i][0] = dp[j][0] = 0
        4. 遍历顺序
            从左到右
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 初始化 dp 数组
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // 遍历 dp 数组
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                // 如果 text1[i-1] == text2[j-1]
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // 如果 text1[i-1] != text2[j-1]
                    // 取 text1[i-2] text2[j-1] 和 text1[i-1] text2[j-2] 的最长公共子序列较长的长度
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
