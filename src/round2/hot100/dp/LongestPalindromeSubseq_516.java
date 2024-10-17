package round2.hot100.dp;

public class LongestPalindromeSubseq_516 {
    /*
        1. dp[i][j]: 从 s[i] 到 s[j] 的最长回文子序列的长度
        2. 因为不要求连续，当 s[i] == s[j] 时，不需要根据 j - i 的长度分类讨论
            如果 s[i] == s[j]
                dp[i][j] = dp[i+1][j-1] + 2
            else
                max(dp[i+1][j], dp[i][j-1])
        3. 初始化
            dp[i][i] = 1;
        4. dp[i][j] 由左下角或者左边推导而来，应该从下到上，从左到右
     */
    public int longestPalindromeSubseq(String s) {
        // 初始化 dp 数组
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][s.length() - 1];
    }
}
