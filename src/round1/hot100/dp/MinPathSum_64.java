package round1.hot100.dp;

public class MinPathSum_64 {
    /*
        最小路径和
        1. dp[i][j] 从起点到达 (i, j) 的最小路径
        2. 递推公式
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        3. 初始化
            dp[i][0] = grid[i][0]  dp[0][j] = grid[0][j]
        4. 遍历顺序: 从左到右从上到下
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 初始化 dp 数组
        int[][] dp = new int[m][n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for (int j = 0; j < n; j++) {
            sum += grid[0][j];
            dp[0][j] = sum;
        }

        // 遍历 dp 数组
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];


        return dp[m - 1][n - 1];
    }
}
