package round2.hot100.dp;

public class LongestPalindrome_5 {
    /*
        最长回文子串
        思路相同，记录最长回文子串
        1. dp[i][j]: i 到 j 是否为回文子串
        2. 考虑两种情况
            当 s[i] != s[j] 一定不是回文子串
            当 s[i] == s[j] 时
            - 如果 j - i <= 1 都为回文子串
            - 如果 j - i > 1 时，dp[i+1][j-1] = true 时，为回文子串
        3. 初始化为 false
        4. 由于 dp[i][j] 由 dp[i+1][j-1] 推导而来，也就是从左下角推导而来
            遍历顺序应该从下往上，从左往右
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        // 初始化 dp 数组
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 0;
        String resStr = "";
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    // 如果子串长度 <= 1，一定是回文串
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        // 当前回文串大于最大长度，记录字符串
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            resStr = s.substring(i, j + 1);
                        }
                    }
                    // j - i 长度大于 1
                    else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            if (j - i + 1 > maxLen) {
                                maxLen = j - i + 1;
                                resStr = s.substring(i, j + 1);
                            }
                        }
                    }
                }
            }
        }
        return resStr;
    }
}
