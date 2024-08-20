package round2.dp;

import java.util.Arrays;

public class CalculateMinimumHP_174 {
    /*
        倒序 dp，因为如果定义 dp[i][j] 为起点出发到达 [i][j] 终点的所需的最小初始值会矛盾，
        即使知道了 左方和上方的值，仍然不知道位于左方和上方的最小初始值
        变成当前值由右方或者下方决定
        1. dp[i][j] 为从 [i][j] 出发到达起点所需的最小初始值
        2. 递推公式
            minn = Math.min(dp[i + 1][j],dp[i][j + 1]);
            dp[i][j] = Math.max(minn - dungeon[i][j], 1);

        3. 初始化: 将 dp 数组每个位置初始化为 最大值
        4. 从右往左，从下往上
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // 初始化 dp 数组
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        // 因为要从右下角开始遍历，且当前位置由右边或者下面决定，初始化这两格
        dp[m][n - 1] = dp[m - 1][n] = 1;
        // 遍历 dp 数组
        for (int i = m - 1; i <= 0; i--) {
            for (int j = n - 1; j <= 0; j--) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }
}
