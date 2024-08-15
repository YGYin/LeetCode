package round2.dp.bag;

public class Change_518 {
    /*
        零钱兑换 II
        求凑成总金额的物品组合个数(不强调元素的排列顺序)
        1. dp[j]: 凑成总金额为 j 的零钱组合为 dp[j] 种方法
        2. 递推公式:
            dp[j] 就是所有 dp[j - coins[i]]
            类似于选了其中一种硬币之后有多少种方法将背包装满
            dp[j] += dp[j - coins[i]]
        3. 初始化：
            dp[0] = 1，装满容量为 0 的背包有一种方法
        4. 确认遍历顺序:
            完全背包，先物品后背包，先背包再物品会变成求排列
     */

    public int change(int amount, int[] coins) {
        // 初始化 dp 数组
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // 遍历 dp 数组，先物品后背包
        //
        for (int i = 0; i < coins.length; i++) {
            // 必须从 coins[i] 开始，不然数组可能会越界
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
                System.out.println("dp_" + j + ": " + dp[j]);
            }
            System.out.println();
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        Change_518 test = new Change_518();
        int method = test.change(5, new int[]{1, 2, 5});
        System.out.println("The number of method: " + method);
    }
}
