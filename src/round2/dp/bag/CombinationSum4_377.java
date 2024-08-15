package round2.dp.bag;

public class CombinationSum4_377 {
    /*
        组合总和 Ⅳ
        求凑成总金额的物品排列个数(强调元素的排列顺序)
        1. dp[j]: 凑成总金额为 j 的零钱组合为 dp[j] 种方法
        2. 递推公式:
            dp[j] 就是所有 dp[j - coins[i]]
            类似于选了其中一种硬币之后有多少种方法将背包装满
            dp[j] += dp[j - coins[i]]
        3. 初始化：
            dp[0] = 1，装满容量为 0 的背包有一种方法
        4. 确认遍历顺序:
            完全背包求排列，先背包后物品，先物品再背包为求组合

            假设有零钱 {1, 2, 5}，target = 5
            先物品后背包的话，就会先将物品 1 加入计算再加入 5 计算，
            只存在 {1, 5}，不存在 {5, 1} 的情况

            如果先遍历背包再遍历物品，背包容量每一个值都会经历物品 1 和 5 的计算
            包含了 {1, 5} 和 {5, 1} 的情况，为排列
     */
    public int combinationSum4(int[] nums, int target) {
        // 初始化 dp 数组
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // 求方法的排列数，先背包后物品
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                // dp[j] += dp[j - nums[i]] 会越界
                // 只有当前容量大于等于当前物品才有意义
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                    System.out.println("dp_" + j + ": " + dp[j]);
                }
            }
            System.out.println();
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSum4_377 test = new CombinationSum4_377();
        int method = test.combinationSum4(new int[]{1, 2, 5}, 5);
        System.out.println("Method: " + method);
    }
}
