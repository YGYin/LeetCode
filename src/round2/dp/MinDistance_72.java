package round2.dp;

public class MinDistance_72 {
    /*
        编辑距离
        相对于 两个字符串的删除操作，本题多了可以增加以及替换字符的操作
        1. dp[i][j]: 将以 i-1 结尾的 word1 转换成以 j-1 结尾的 word2 所需的最少操作数
        2. 递推公式:
            如果 word1[i - 1] == word2[j - 1]
                dp[i][j] = dp[i - 1][j - 1]，在原来基础上不用操作修改
            如果两者不相等
            - 删除，可以删除 word1[i - 1] 或者删除 word2[j - 1]，
                即为在 dp[i - 1][j] 或者 dp[i][j - 1] 的基础上 + 1
                dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
            - 增加，本质上其实操作数和删除是等价的
                ab 和 a，在 word1 删除 b 等价于在 word2 增加 b，所以已经被删除操作所包含
            - 替换
                ab 和 ac
                dp[i][j] = dp[i - 1][j - 1] + 1，在原来的基础上修改一个字符，直接 + 1
        3. 初始化
            dp[i][0] = i, dp[0][j] = j
            相当于一个字符串更改 i 次或者 j 次变为空串的操作次数
        4. 根据递推公式，dp[i][j] 可以由上方左上方和左方能推到，所以顺序为从左到右从上到下
     */
    public int minDistance(String word1, String word2) {
        // 初始化 dp 数组
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;

        for (int j = 0; j <= word2.length(); j++)
            dp[0][j] = j;

        // 遍历 dp 数组
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // 如果 word1[i - 1] == word2[j - 1]，在原来基础上不操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                    // 删除 i-1 或者删除 j-1 或者修改
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
