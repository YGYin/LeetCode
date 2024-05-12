package round1.dp;

public class IntegerBreak_343 {
    public int integerBreak(int n) {
        /*
            整数拆分
            1. dp[i] 表示对 i 进行拆分能得到的最大乘积为 dp[i]
            2. 递推公式:
                得到 dp[i] 要么直接通过 j * (i - j) -> 拆分成两个
                或者继续拆分 j * dp[i - j] -> 拆分成两个及以上
                无需再对 j 拆分，因为 j 从 1 开始遍历，拆分 j 的情况其实都计算过了
                因为取最大值，每次计算 dp[i]，还要取最大的
                dp[i]= max(dp[i], max(j * (i - j), j * dp[i - j]));
            3. dp 数组初始化
                按照 dp 数组定义，dp[0] dp[1] 没办法再拆分，实际无意义
                dp[2] = 1
            4. 遍历顺序: dp[i] 依赖于 dp[i - j]的状态，所以从前往后遍历
         */
        // 无需特判 n >= 2
        // 定义 dp 数组以及初始化，求第 n 个，数组大小为 n + 1
        int[] dp = new int[n + 1];
        dp[2] = 1;
        // 从 3 开始
        for (int i = 3; i <= n; i++)
            for (int j = 0; j < i; j++)
                // 这里的 j 其实最大值为 i - j,再大只不过是重复而已，
                // 并且在本题中， dp[0], dp[1]都是无意义的，
                // j 最大到 i - j，就不会用到 dp[0]与dp[1]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));


        return dp[n];
    }
}
