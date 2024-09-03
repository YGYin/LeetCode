package round2.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MinDistance_583 {
    /*
        两个字符串的删除操作
        给定两个单词 word1 和 word2 ，返回使得 word1 和 word2 相同所需的最小步数
        1. dp[i][j]: 以 word1[i-1] 和 word[j-1] 结尾的使两字符串相同的最小删除步数
        2. 递推公式：
            考虑 word1[i-1] 和 word[j-1] 是否相等的情况
            - 如果相等，最小删除步数和 i-2 以及 j-2 状态相同
                dp[i][j] = dp[i-1][j-1]
            - 如果不相等，有三种情况
                1. 删除 word1[i-1]
                2. 删除 word2[j-1]
                3. 同时删除删除 word1[i-1] word2[j-1]
                   因为 dp[i][j-1] + 1 = dp[i-1][j-1] + 2
                   从字面上理解就是当同时删 word1[i-1] 和 word2[j-1]，
                   dp[i][j-1] 本来就不考虑 word2[j-1] 了，
                   那么在删 word1[i-1]，就达到两个元素都删除的效果，即 dp[i][j-1] + 1
                dp[i][j] = min(dp[i-1][j] + 1, dp[i][j-1] + 1)
         3. 初始化
            dp[i][0] = i    dp[0][j] = j
         4. 遍历顺序
            从左到右，从上到下
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
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
