package round2.dp.basic;

public class NumTrees_96 {
    /*
        不同的二叉搜索树
        求 n 个节点 1 ～ n 能构成多少个不同的二叉搜索树
        1. dp[i]: i 个节点最多能构成 dp[i] 种二叉搜索树
        2. 递推公式:
            考虑 n = 3 的情况，一个节点为根节点，那么子节点有以下三种分布情况
            左子树由 0，1 个或 2 个节点构成，右子树同理
            那么 n = 3 时可能的二叉搜索树为:
            dp[3] = dp[0]dp[2] + dp[1]dp[1] + dp[2]dp[0]
            假设用 j 做根节点，比 j 小的共有 j - 1个节点构成左子树，比 j 大的有 i - j 个节点构成右子树
            dp[i] += dp[j - 1]dp[i - j]
        3. 初始化:
            dp[0] = 1 dp[1] = 1

        4. 遍历顺序: 节点数为 i 的状态是依靠 i 之前节点数的状态
     */
    public int numTrees(int n) {
        // 初始化 dp 数组
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            // j 需要从 1 开始，因为至少用值为 1 作为根节点
            for (int j = 1; j <= i; j++)
                // 一共 i 个节点，左子树节点个数为 j - 1，右子树节点个数为 i - j
                dp[i] += dp[j - 1] * dp[i - j];


        return dp[n];
    }
}
