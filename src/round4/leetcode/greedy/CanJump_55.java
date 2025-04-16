package round4.leetcode.greedy;

public class CanJump_55 {
    /*
        不关心每次跳多少步，怎么跳，关心最大跳跃范围是否覆盖终点
     */
    public boolean canJump(int[] nums) {
        // 记录当前最大覆盖范围
        int coverRange = 0;
        // 应该由当前的覆盖范围来决定遍历边界
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            // 如果当前覆盖范围已经能达到最后一个下标
            if (coverRange >= nums.length - 1)
                return true;
        }

        return false;
    }
}
