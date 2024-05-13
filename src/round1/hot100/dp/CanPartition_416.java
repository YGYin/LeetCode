package round1.hot100.dp;

public class CanPartition_416 {
    public boolean canPartition(int[] nums) {
        /*
            分割等和子集
            分割两个子集，使得两个子集的元素和相等，本题可以转化为 0-1 背包问题
            此处刚好容量大小即为价值大小，可以直接套入 0-1 背包
            -> 背包容量为 target = 数组和 / 2，找到 dp[target] = target
            1. dp[j]: 当背包容量为 j 时的最大价值
            2. 递推公式:
                在不选取物品 i 和选取物品 i 的最大价值中取 max
                dp[j] = max(dp[j], dp[j - weight[i]] + value[i])
            3. dp 数组初始化:
                dp[0] = 0; dp[后续非负数] = 0，方便做 max 比较
            4. 遍历顺序:
                因为是压缩到一维数组，先遍历物品再遍历背包容量
                同时在遍历背包容量时需要倒序，
                因为在二维数组中，都是由上方或左上方的值来决定当前的值；
                但是压缩为一维数组后，需要复用左边的值。
                如果从左往右顺序遍历一维数组，等于在装背包的过程中同时修改了前面的状态
                相当于在装了物品 i 的状态下扩大容量重复装物品 i
                而倒序遍历则没有改变左边的值(状态)，相当于保证了只装一次物品 i
         */
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        // 背包容量为 target，可以等于 target，所以数组大小为 target + 1
        int[] dp = new int[target + 1];
        // 先遍历物品
        for (int i = 0; i < nums.length; i++) {
            // 再遍历背包，一维数组需要倒序
            // j >= weight[i] 保证至少能装一个物品 i
            for (int j = target; j >= nums[i]; j--)
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            // 遍历完当前商品后，看拿了是否等于 target
            if (dp[target] == target)
                return true;
        }

        return dp[target] == target;
    }
}
