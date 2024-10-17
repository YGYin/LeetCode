package round2.hot100.dp;

public class UniquePaths_62 {
    /*
        不同路径
        1. dp[i][j]: 到达坐标 (i, j) 的不同路径数
        2. dp[i][j] = do[i-1][j] + dp[i][j-1]
        3. 因为只能向右或者向下移动，第一行和第一列初始为 1
        4. 从左到右，从上到下
     */
    public int uniquePaths(int m, int n) {
        // 初始化 dp 数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < m; j++)
            dp[0][j] = 1;

        // 遍历 dp 数组
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }
}
