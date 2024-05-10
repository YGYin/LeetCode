package round1.hot100.dp;

public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        /*
            不同路径:
            1. dp[i][j]: 从 [0][0] 走到 [i][j] 有 dp[i][j] 种路径(非步数)
            2. 递推公式
                只能往右走或者往下走
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            3. dp 数组初始化:
                因为从上方或者从左边到当前位置，所以上侧和左侧需要初始化
                dp[0][j] 第一行只有一种走法
                dp[i][0] 第一列也只有一种走法，都初始化为 1
            4. 遍历顺序: 从左往右，从上往下
         */
        // 定义 dp 数组，并进行初始化
        int[][] dp = new int[m][n];
        // 第一列初始化为 1
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        // 第一行初始化为 1
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        // 从 (1, 1) 开始遍历网格
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        // 返回可以到达右下角终点的路径数
        return dp[m - 1][n - 1];
    }
}
