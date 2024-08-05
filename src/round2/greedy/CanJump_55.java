package round2.greedy;

public class CanJump_55 {
    /*
        跳跃游戏
        不需要关心如何选择怎么跳跳多少步，关键在于可跳的覆盖范围
        遍历数组
        局部最优 -> 每次都取最大的可覆盖范围
        整体最优 -> 看覆盖范围是否能覆盖到终点，能则返回
     */
    public boolean canJump(int[] nums) {
        // 题目最少有一个元素
        if (nums[0] >= nums.length - 1)
            return true;

        int coverRange = 0;
        // 注意只能到 coverRange
        for (int i = 0; i <= coverRange; i++) {
            // 更新当前的最大覆盖范围
            coverRange = Math.max(coverRange, i + nums[i]);
            // 看是否能覆盖到终点
            if (coverRange >= nums.length - 1)
                return true;
        }

        return false;
    }
}
