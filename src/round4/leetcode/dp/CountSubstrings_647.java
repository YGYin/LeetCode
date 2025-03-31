package round4.leetcode.dp;

public class CountSubstrings_647 {
    /*
       回文子串的个数
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
    public int countSubstrings(String s) {
        // 初始化 dp 数组，默认都为 false
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 记录回文子串个数
        int count = 0;

        // 从下往上，从左往右遍历，考虑边界 j 应该 >= i
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        ++count;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            ++count;
                        }
                    }
                }
            }
        }
        return count;
    }
}
