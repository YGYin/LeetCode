package round2.greedy;

public class Jump_45 {
    /*
        跳跃游戏 II
        相对于 跳跃游戏 I 要求到达终点步数最少
        1. 需要统计当前这步的最大覆盖范围，以及统计下一个步的最大覆盖范围
        2. 如果遍历到达当前 coverRange 后还没到达终点，说明需要再走一步 ++ 步数
        移动下标只要遇到当前覆盖最远距离的下标，直接步数加一，不考虑是不是终点的情况。
     */
    public int jump(int[] nums) {
        int step = 0;
        int curRange = 0;
        int nextRange = 0;
        // 移动下标只要遇到当前覆盖最远距离的下标，直接步数加一
        // 不考虑是不是终点的情况。所以 i < nums.length - 1
        for (int i = 0; i < nums.length - 1; i++) {
            // 同样先更新下一步所能覆盖的最大距离
            nextRange = Math.max(nextRange, i + nums[i]);
            // 当到达当前最大范围时，更新当前最大覆盖范围，步数 ++
            if (i == curRange) {
                curRange = nextRange;
                ++step;
            }
        }
        return step;
    }
}
