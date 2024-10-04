package round2.hot100.greedy;

public class CanJump_55 {
    /*
        不关心每次跳多少步，怎么跳，关心最大跳跃范围是否覆盖终点
        注意遍历边界不为 nums.length 而是 coverRange
     */
    public boolean canJump(int[] nums) {
        int coverRange = 0;
        // 不能小于 nums.length，边界在于 coverRange
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1)
                return true;
        }

        return false;
    }
}
