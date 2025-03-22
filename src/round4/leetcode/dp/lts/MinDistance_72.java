package round4.leetcode.dp.lts;

public class MinDistance_72 {
    /*
        编辑距离
        1. dp[i][j]: word1[i-1] 转换为 word2[j-1] 所需的最少操作数
        2. 考虑
            - word1[i-1] == word2[j-1]
                直接等于原来基础的操作数
            - word1[i-1] != word2[j-1]
                1. 增和删其实是等效的，都相当于在 i-2 或者 j-2 的字符串加 1 操作数
                2. 替换这是在 i-2 和 j-2 的操作数基础上 + 1
        3. 初始化
            dp[i][0] = i; dp[0][j] = j
        4. 从左到右，从上到下
     */
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        // 初始化 dp 数组
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i <= chars1.length; i++)
            dp[i][0] = i;
        for (int j = 0; j <= chars2.length; j++)
            dp[0][j] = j;

        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
