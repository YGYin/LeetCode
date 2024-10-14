package round2.hot100.dp;

public class MinPathSum_64 {
    /*
        最小路径和
        1. dp[i][j]: 到达 i, j 的最小路径和
        2. dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        3. 第一行和第一列初始化为 grid 的数值
        4. 从左到右，从上到下
     */
    public int minPathSum(int[][] grid) {
        // 初始化 dp 数组
        int[][] dp = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }

        sum = 0;
        for (int j = 0; j < grid[0].length; j++) {
            sum += grid[0][j];
            dp[0][j] = sum;
        }

        for (int i = 1; i < grid.length; i++)
            for (int j = 1; j < grid[0].length; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
