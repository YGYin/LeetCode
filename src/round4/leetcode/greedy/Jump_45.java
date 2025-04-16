package round4.leetcode.greedy;

public class Jump_45 {

    /*
        跳跃游戏 II
        1. 区别在于需要统计步数，同样贪最大范围，但需要记录当前范围和全局最大范围
        2. 先更新最大覆盖范围
        3. 当到达当前覆盖范围的边界时，说明需要再走一步才能到达，更新当前覆盖边界
     */
    public int jump(int[] nums) {
        int curCover = 0;
        int maxCover = Integer.MIN_VALUE;
        int steps = 0;

        // 再跳一次就刚好到达 nums.length - 1
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新最大覆盖范围
            maxCover = Math.max(maxCover, i + nums[i]);
            // 如果已经到达当前覆盖边界，尝试更新边界，++ steps
            if (i == curCover) {
                ++steps;
                curCover = maxCover;
            }
        }
        return steps;
    }
}
