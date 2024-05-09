package round1.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate_118 {
    public List<List<Integer>> generate(int numRows) {
        /*
            杨辉三角
            1. dp[i][j] 代表杨辉三角中第 i 行第 j 列的元素值为 dp[i][j]
            2. 递推公式: dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
            3. dp 数组初始化: 每一行的第一个和最后一个元素为 1
            4. 遍历顺序: 从前往后，从上往下
         */
        // 定义 dp 数组，每行有多少列由行数决定
        Integer[][] dp = new Integer[numRows][];
        // 遍历每一行
        for (int i = 0; i < numRows; i++) {
            // 初始化当前行
            dp[i] = new Integer[i + 1];
            // 初始化当行的首尾元素为 1
            dp[i][0] = 1;
            dp[i][i] = 1;
            // 再计算中间元素（j = 1; j < 1; 跳过首尾元素）
            for (int j = 1; j < i; j++)
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }

        // 转化为 list
        List<List<Integer>> res = new ArrayList<>();
        for (Integer[] row : dp)
            res.add(Arrays.asList(row));

        return res;
    }
}
