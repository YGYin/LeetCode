package round1.hot100.dp;

import java.util.Arrays;

public class MinDistance_72 {
    /*
        编辑距离: word1 通过增删改转换成 word2 的最少操作数
        1. dp[i][j] 以下标 i - 1 为结尾的 word1 和
                    以下标 j - 1 为结尾的 word2 的最近编辑距离
        2. 递推公式:
            - 如果 word1[i - 1] == word[i - 2] 则不操作
                dp[i][j] = dp[i - 1][j - 1]
            - 如果 word1[i - 1] != word[i - 2]
                - word1 删除一个元素，操作数 + 1 (相当于 word2 添加一个元素)
                 dp[i][j] = dp[i - 1][j] + 1
                - word2 删除一个元素，操作数 + 1
                 dp[i][j] = dp[i][j - 1] + 1
                - 替换，长度则和 word1[i -2] word2[i - 2]没变化，操作数 + 1
                 dp[i][j] = dp[i - 1][j - 1] + 1
        3. 初始化
            dp[i][0] 相当于以 word1[i - 1] 和空字符串的最小编辑距离
            相当于要更改 i 次才能一致，dp[0][j] 同理
            dp[i][0] = i  dp[0][j] = j
        4. 遍历顺序:
            dp[i][j] 的状态由
            dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1] 得到
            由左上，上，和左方得到，从上到下从左到右遍历
     */
    public int minDistance(String word1, String word2) {
        char[] wordArr1 = word1.toCharArray();
        char[] wordArr2 = word2.toCharArray();
        // 初始化 dp 数组
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++)
            dp[0][j] = j;

        // 遍历 dp 数组
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // 如果 word1[i - 1] == word2[j - 1] 相等，不修改
                if (wordArr1[i - 1] == wordArr2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                    // 不相等，三种修改方式里取最小值
                else
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]) + 1;

                System.out.println(Arrays.deepToString(dp));
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        MinDistance_72 minDist = new MinDistance_72();
        System.out.println(minDist.minDistance("horse", "ros"));
    }
}
