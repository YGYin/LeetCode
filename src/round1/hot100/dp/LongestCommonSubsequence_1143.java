package round1.hot100.dp;

public class LongestCommonSubsequence_1143 {
    /*
        最长公共子序列
        和最长重复子数组区别在于该题没有要求序列连续
        1. dp[i][j] 为text1[0, i - 1]和 text2[0, j - 1] 的最长公共子序列
        2. 递推公式:
            找到一个公共元素，+ 1
            if(text1[i - 1] == text2[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1
            如果当前不为公共元素
            看 text1[0, i - 2] 与 text2[0, j - 1]的最长公共子序列
            和 text1[0, i - 1] 与 text2[0, j - 2]的最长公共子序列
            else
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

            相对于之前自从左上角推出当前状态，需要考虑从左边和上方推出当前状态
        3. 初始化
            dp[0][j] = dp[i][0] = 0
        4. 遍历顺序: 从上到下从左到右
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] textArr1 = text1.toCharArray();
        char[] textArr2 = text2.toCharArray();
        // 此处返回的为完整字符串的结果，为 dp[text1.length][text2.length}
        // 初始化 dp 数组
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= textArr1.length; i++) {
            for (int j = 1; j <= textArr2.length; j++) {
                // 无论如何 dp[i][j] 都会取到左上和左和上方的最大值
                // 所以可以返回 dp[text1.length()][text2.length()] 作为答案
                // 不需要在遍历过程中额外记录 res
                if (textArr1[i - 1] == textArr2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
