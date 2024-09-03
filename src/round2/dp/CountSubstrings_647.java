package round2.dp;

public class CountSubstrings_647 {
    /*
        回文子串
        给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目
        如果将 dp[i] 定义为下标 i 结尾的字符串有 dp[i] 个回文串的话，很难找到递归关系
        考虑类似于中心扩散法，看 i 到 j 是否为回文串
        1. dp[i][j]: 从 s[i] 到 s[j] 是否为回文串
        2. 递推公式: 考虑三种情况
            - 当 s[i] 和 s[j] 相等时
              1 & 2. 如果长度为 1 或 2，即 j - i <= 1，一定为回文串
                设 dp[i][j] 为 true，result++
              3. 长度大于 2 时，j - i >= 2
                如果 dp[i+1][j-1] 为 true 那么 dp[i][j] 也为 true 说明就是字符串
                设 dp[i][j] 为 true，result++
            - 当 s[i] 和 s[j] 不相等，不处理，因为布尔数组默认为 false
        3. 初始化
            默认为 false
        4. 遍历顺序
            dp[i][j] 的状态由 dp[i+1][j-1] 推导而来，也就是从左下角推导而来
            遍历顺序应该从下往上，从左往右

     */
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 初始化 dp 数组
        boolean[][] dp = new boolean[len][len];
        int res = 0;

        // 遍历 dp 数组
        for (int i = len - 1; i >= 0; i--) {
            // j 必须大于 i，相当于 i 为左边界，j 为右边界
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]) {
                    // 如果 s[i] = s[j]，分长度情况讨论
                    if (j - 1 <= 1) {
                        dp[i][j] = true;
                        ++res;
                    } else {
                        // 长度大于 2，看中间部份是否为回文串
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            ++res;
                        }
                    }
                }
            }
        }

        return res;
    }
}
