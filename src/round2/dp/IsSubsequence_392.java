package round2.dp;

public class IsSubsequence_392 {
    /*
        判断子序列
        给定字符串 s 和 t ，判断 s 是否为 t 的子序列。"ace" 是 "abcde" 的一个子序列
        1. 双指针
            相等 s 的指针就后移，看最后指针是否刚好遍历完字符串 s

        2. dp
            其实本质上和求最长公共子序列几乎相同，只是 s 要求连续每一个都满足，t 不连续
            - dp[i][j]: s[i-1] 和 t[j-1] 结尾的最长公共子序列的长度
            - 递推公式:
                如果 s[i - 1] == t[i - 1]
                    dp[i][j] = dp[i - 1][j - 1] + 1
                否则的话，s 必须每个字符满足不能删除，只能在 t 中删除
                    s[i-1] 和 t[j-1] 结尾的最长公共子序列的长度则取 s[i-1] 和 t[j-2] 结尾的最长公共子序列的长度
                    dp[i][j] = dp[i][j - 1]
            - 初始化
                dp[i][0] = dp[0][j] = 0
            - 遍历顺序
                从左到右，从上到下
     */
    public boolean isSubsequence(String s, String t) {
        // 初始化 dp 数组
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }
        // 看最后最长公共子序列的长度是否刚好等于 s 的长度
        return dp[s.length()][t.length()] == s.length();
    }

    public boolean isSubsequenceDPTR(String s, String t) {
        if (s.isEmpty())
            return true;

        int sIndex = 0;
        for (int i = 0; i < t.length() && sIndex < s.length(); i++)
            if (s.charAt(sIndex) == t.charAt(i))
                ++sIndex;

        return sIndex == s.length();
    }
}
