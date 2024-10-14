package round2.hot100.dp;

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
        if (s.length() == 1)
            return 1;

        // 初始化 dp 数组
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 记录回文子串个数
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            // 考虑 dp 定义，j 为右边界一定要大于 i
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        ++res;
                        dp[i][j] = true;
                    } else {
                        // 如果收缩一个字符之后也是回文串，当前也为回文串
                        if (dp[i + 1][j - 1]) {
                            ++res;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return res;
    }
}
