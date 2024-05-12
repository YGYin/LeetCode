package round1.hot100.dp;

public class UniquePathsWithObstacles_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
            不同路径 II
            与不同路径不同的是加入了障碍物
            1. dp[i][j] 代表到达 [i][j] 时有 dp[i][j] 条不同的路径
            2. 递推公式: 只能向右走或者向下走，当前格子状态由上方或左方决定
                        但需要判断当前(i, j)没有障碍物才执行递推公式
                    if (obs[i][j] == 0)
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            3. dp 数组初始化也有区别，因为只能向右走或者向下走，
                一旦第一行或者第一列出现障碍物后，后方全部无法到达设置为 0
            4. 遍历顺序: 从左到右从上到下
         */
        // 可以先特判，如果起始点和终点存在障碍物的话就不存在路径
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowLen - 1][colLen - 1] == 1)
            return 0;
        // 定义并初始化 dp 数组的第一列和第一行
        int[][] dp = new int[rowLen][colLen];
        for (int i = 0; i < rowLen && obstacleGrid[i][0] == 0; i++)
            dp[i][0] = 1;
        for (int j = 0; j < colLen && obstacleGrid[0][j] == 0; j++)
            dp[0][j] = 1;

        // 遍历并更新 dp 数组
        for (int i = 1; i < rowLen; i++)
            for (int j = 1; j < colLen; j++) {
                // 只有(i, j)不存在障碍物的时候才递推
                if (obstacleGrid[i][j] == 1)
                    continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        return dp[rowLen - 1][colLen - 1];
    }
}
