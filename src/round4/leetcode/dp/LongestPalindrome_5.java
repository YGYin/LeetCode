package round4.leetcode.dp;

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
        // 记录当前最大长度和最长的子串
        int maxLen = 0;
        String resStr = "";

        // 从下到上，从左到右，j 应该 >= i
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // j - i 长度小于等于 1 一定为回文子串
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        // 更新长度
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            resStr = s.substring(i, j + 1);
                        }
                    }
                    // j - i 长度 > 1 检查分别收缩一个字符时是否为回文串
                    else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            // 更新长度
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
