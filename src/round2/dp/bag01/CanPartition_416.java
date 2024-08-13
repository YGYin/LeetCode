package round2.dp.bag01;

public class CanPartition_416 {
    /*
        分割等和子集
        1. 这道题目是要找是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
            那么只要找到集合里能够出现 sum / 2 的子集总和，就算是可以分割成两个相同元素和子集了
        2. 背包问题：n 件物品，和最多能背重量为 w 的背包
            因为每个元素只能用一次 -> 01背包
            找和为 sum / 2 的子集 -> 背包容量为 sum / 2
            元素的数值恰好为物品的价值和重量
            如果背包正好装满，说明找到总和为 sum / 2 的子集
        1. dp[j]: 背包容量为 j 时最大价值为 dp[j]
            因为要求刚好装满重量 target 时价值为 dp[target]，
            则求 dp[target] == target
        2. 递推公式:
            dp[j] = max(dp[j], dp[j - num[i]] + nums[i])
        3. 初始化:
            一维 dp 数组初始化为 0
            二位数组初始化第一列(背包容量为 0)为 0，第一行在大于第一个物品后初始化为该物品重量
        4. 遍历顺序
            先物品后背包，同时从后向前
     */
    public boolean canPartition(int[] nums) {
        // dp 数组容量为 sum / 2，所以先求总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        // 考虑如果是奇数不可能平分
        if (sum % 2 == 1)
            return false;
        // 初始化 dp 数组
        int target = sum / 2;
        int[] dp = new int[target + 1];

        // 先物品后背包
        for (int i = 0; i < nums.length; i++)
            for (int j = target; j >= nums[i]; j--)
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);

        return dp[target] == target;
    }

    public boolean canPartition_2(int[] nums) {
        // 二维数组版本
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        // 如果不能整除 2 则无法平分
        if (sum % 2 == 1)
            return false;
        // 初始化 dp 数组
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        // 对第一行能装下第一个物品后的 dp 数组需要初始化
        for (int j = nums[0]; j <= target; j++)
            dp[0][j] = nums[0];

        // 遍历二维 dp 数组，同样先物品后背包，但是遍历背包从左到右
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 容量小于物品 i 就不取当前物品 i
                if (j < nums[i])
                    dp[i][j] = dp[i - 1][j];
                    // 可以取物品 i，看是取还是不取的价值更高
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
            }
        }
        return dp[nums.length - 1][target] == target;
    }
}
