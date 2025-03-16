package round4.leetcode.dp;

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
        // 定义 dp 数组，只初始化行，列在后序遍历初始化
        Integer[][] dp = new Integer[numRows][];
        // 遍历 dp 数组
        for (int i = 0; i < numRows; i++) {
            // 初始化当前列，每行的列数等于当前实际行数
            dp[i] = new Integer[i + 1];
            // 首尾设置为 1
            dp[i][0] = 1;
            dp[i][i] = 1;
            // 遍历当前行
            for (int j = 1; j < i; j++)
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }

        // 转为 list
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            res.add(Arrays.asList(dp[i]));

        return res;
    }
}
