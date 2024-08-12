package round2.dp.basic;

public class UniquePathsWithObstacles_63 {
    /*
        不同路径 II
        相对于不同路径 I 有了障碍物，区别只是在于在更新之前判断当前位置是否为 0 (无障碍)
        1. dp[i][j]: 到达 (i , j) 有 dp[i][j] 条路径
        2. 递推公式:
            if(dp[i][j] == 0)
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        3. 初始化:
            同样第一排和第一列初始化为 1，但是如果第一排或者第一列有障碍的话后面应该都为 0
        4. 遍历顺序: 从上到下 从左到右
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 初始化 dp 数组
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] == 0; i++)
            dp[i][0] = 1;

        for (int j = 0; j < obstacleGrid[0].length && obstacleGrid[0][j] == 0; j++)
            dp[0][j] = 1;

        // 从 (1, 1) 开始遍历 dp 数组
        for (int i = 1; i < obstacleGrid.length; i++)
            for (int j = 1; j < obstacleGrid[0].length; j++)
                // 没有障碍物则更新路径数
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];


        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
