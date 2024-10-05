package round2.hot100.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate_118 {
    /*
        杨辉三角
        1. dp[i][j]: 第 i 行第 j 列的数值为 dp[i][j]
        2. dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        3. dp[i][0] = dp[i][i] = 1，每行首元素和尾元素 = 1
        4. 从左到右 从上到下
     */
    public List<List<Integer>> generate(int numRows) {
        // 只初始化行数，循环内每次再初始化列
        Integer[][] dp = new Integer[numRows][];
        for (int i = 0; i < numRows; i++) {
            // 初始化当前行
            dp[i] = new Integer[i + 1];
            dp[i][0] = 1;
            dp[i][i] = 1;
            for (int j = 1; j < i; j++)
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }

        // 转换为 list
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            res.add(Arrays.asList(dp[i]));

        return res;
    }
}
