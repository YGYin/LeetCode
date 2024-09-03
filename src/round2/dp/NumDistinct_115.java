package round2.dp;

public class NumDistinct_115 {
    /*
        不同的子序列
        给两个字符串 s 和 t，统计并返回在 s 的 子序列 中 t 出现的个数
        1. dp[i][j]: 以 s[i-1] 结尾的 s 中出现以 t[j-1] 结尾的 t 的个数
        2. 递推公式
            可以考虑这两种情况
            1.          2.
            s: bagg     s: baxx..
            t: bag      t: baxx
            当 s[i-1] == t[i-1] 时
                dp[i][j] = 使用 s[i-1] 时的个数 + 不使用 s[i-1] 的个数(相当于删去 s[i-1] 选择 s[i-2])
                         = dp[i-1][j-1] + dp[i-1][j]
            当 s[i-1] 和 t[i-1] 不相等时
                dp[i][j] = dp[i-1][j]，因为求的是 t 在 s 的出现次数，只能删 s 不能删 t
        3. 初始化
            需要初始化 dp[i][0] 和 dp[0][j]
            dp[i][0]: t 为空串，t 出现在 s 的次数为 1 次
            dp[0][j]: s 为空串，t 不为空串时出现在空串的次数为 0 次
            dp[0][0] = 1
        4. 遍历顺序: 从左到右，从上到下
     */
    public int numDistinct(String s, String t) {
        // 初始化 dp 数组
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++)
            dp[i][0] = 1;

        // 遍历 dp 数组
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // 如果 s[i-1] == t[i-1] 时
                // 考虑使用 s[i-1] 加上不使用 s[i-1] 将其删除的情况
                // 如果相同使用 s[i-1] 的话，个数和使用 s[i-2] 和 t[i-2] 的情况相同
                // 不使用 s[i-1] 的话，则为 s[i-2] 和 t[i-1]
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    // 如果不相等，和直接删掉该字符的情况是等价的
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[s.length()][t.length()];
    }
}
