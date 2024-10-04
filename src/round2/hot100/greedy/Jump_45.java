package round2.hot100.greedy;

public class Jump_45 {
    /*
        跳跃游戏 II
        1. 区别在于需要统计步数，同样贪最大范围，但需要记录当前范围和全局最大范围
        2. 当到达当前覆盖范围的边界时，说明需要再走一步才能到达
     */
    public int jump(int[] nums) {
        int curCover = 0;
        int maxCover = Integer.MIN_VALUE;
        int steps = 0;

        // 因为题目保证测试用例一定能到达 nums[n - 1]，
        // 可以直接 i < nums.length - 1
        for (int i = 0; i < nums.length - 1; i++) {
            // 先更新 全局最大范围
            maxCover = Math.max(maxCover, i + nums[i]);
            // 已到达当前覆盖范围边界，步数 ++
            if (i == curCover) {
                ++steps;
                curCover = maxCover;
            }
        }
        return steps;
    }
}
