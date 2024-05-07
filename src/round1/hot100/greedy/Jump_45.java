package round1.hot100.greedy;

public class Jump_45 {
    public int jump(int[] nums) {
        /*
            跳跃游戏 II
            同样是看能不能跳到终点，但是求跳到终点的最小步数
            也是贪心，每次贪跳得最远距离，从而看能不能给覆盖得到终点
            2 3 1 1 4
            ----- 在当前最大范围内走完之后，就要将当前最大范围更新为全局最大范围，必须要走一步
              ------- 到达
         */
        // 特判
        if (nums.length == 1)
            return 0;

        int count = 0;
        // 当前覆盖的区域
        int curCover = 0;
        // 实际最大覆盖区域
        int maxCover = 0;
        // 因为生成的测试用力一定能到达 nums[n - 1]，可以直接用 nums.length
        for (int i = 0; i < nums.length; i++) {
            // 先更新最大覆盖范围
            maxCover = Math.max(maxCover, i + nums[i]);
            // 看看最大范围是否覆盖到终点
            if (maxCover >= nums.length - 1) {
                ++count;
                break;
            }
            // 同时如果走到当前覆盖最大范围的尾部时，更新当前的最大范围
            if (i == curCover) {
                curCover = maxCover;
                count++;
            }
        }

        return count;
    }
}
