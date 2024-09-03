package round2.dp;

public class LongestPalindromeSubseq_516 {
    /*
        最长回文子序列
        同样考虑使用中心扩散的方法，回文子序列要求不需要连续，当 s[i] 和 s[j] 相同时不需要考虑按长度分类讨论
        1. dp[i][j]: 在 s[i, j] 范围内的最长回文子序列的长度
        2. 递推公式:
            当 s[i] = s[j] 时，相当在原来回文序列长度往外扩展
                dp[i][j] = dp[i+1][j-1] + 2
            当不相等时，考虑不取 s[i] 或者不取 s[j] 的最长回文序列长度
                dp[i][j] = max(dp[i+1][j], dp[i][j-1])
        3. 初始化
            当 i = j 时，dp[i][j] = 1，其他情况初始化为 0
        4. 遍历顺序
            根据递推公式，dp[i][j] 由左 左下 和 下方推导得到，所以从下到上，从左到右
     */
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 1)
            return 1;
        char[] chars = s.toCharArray();
        // 初始化 dp 数组
        int[][] dp = new int[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++)
            dp[i][i] = 1;

        // 遍历 dp 数组
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j])
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        // 返回 s[0, len - 1] 的最长回文子序列
        return dp[0][chars.length - 1];
    }
}
