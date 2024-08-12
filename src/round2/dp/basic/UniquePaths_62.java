package round2.dp.basic;

public class UniquePaths_62 {
    /*
        不同路径
        1. dp[i][j]: 到达 (i, j) 节点时，有 dp[i][j] 种路径
        2. 递推公式:
            因为只能当前节点只能从上方或者左方到达，
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        3. 初始化:
            因为每次只能向右或者向下移动，第一行和第一列只有一种可能
            dp[0][j] = dp[i][0] = 1
        4. 遍历顺序: 从左到右，从上到下，应该从 dp[1][1] 开始
     */
    public int uniquePaths(int m, int n) {
        // 初始化 dp 数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        // 遍历数组
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }
}
