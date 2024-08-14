package round2.dp.bag01;

import java.util.Arrays;


public class FindTargetSumWays_494 {
    /*
        目标和
        类似于组合总和，回溯搜
        本质上可以将数组分为正数组 a 和负数组 b
        a + b = sum, a - b = target
        a + b + a - b = sum + target
        a = (sum + target) / 2
        所以本质就是找到和为 (sum + target) / 2 的数组，通过回溯搜
     */
    // 记录当前路径和所有路径
    int res;

    public int findTargetSumWays(int[] nums, int target) {
        // 排序，方便回溯做剪枝
        Arrays.sort(nums);
        // 先特判，如果全部相加都小于目标和则无答案
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum < target)
            return 0;
        // 如果是奇数的话没有办法整除满足 (sum + target) / 2 没有结果
        if ((sum + target) % 2 == 1)
            return 0;
        // 实际找目标和为  (sum + target) / 2
        target = (sum + target) / 2;

        backtracking(nums, target, 0, 0);
        return res;
    }

    private void backtracking(int[] nums, int target, int curSum, int startIndex) {
        // 如果和为 (sum + target) / 2 则收获结果，但因为长度不限需要继续搜
        if (curSum == target)
            ++res;

        // 处理当前层节点
        for (int i = startIndex; i < nums.length; i++) {
            // 剪枝，如果加上当前节点的数字已经大于 target，
            // 同层后序节点没有必要进入到下一层（节点已排序）
            if (curSum + nums[i] > target)
                break;
            backtracking(nums, target, curSum + nums[i], i + 1);
        }
    }
}
