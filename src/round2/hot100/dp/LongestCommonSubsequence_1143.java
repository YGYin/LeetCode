package round2.hot100.dp;

public class LongestCommonSubsequence_1143 {
    /*
        最长公共子序列
        1. dp[i][j]: text1[i-1] 和 text2[j-1] 的最长公共子序列长度
        2. 当 text1[i-1] == text2[j-1] 时，在原来基础上公共序列长度 + 1
            dp[i][j] = dp[i-1][j-1] + 1;
           如果不相等，则考虑删一个字符的情况下的最长公共序列长度
            dp[i][j] = max(dp[i-1][]j], dp[i][j-1])
        3. 初始化 dp[i][0] = dp[0][j] = 0
        4. 从左到右从上到下
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 初始化 dp 数组
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
