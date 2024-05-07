package round1.hot100.greedy;

public class CanJump_55 {
    public boolean canJump(int[] nums) {
        /*
            跳跃游戏
            不去考虑每次跳跃多少步，而是去贪每一次的最大覆盖范围
            局部最大覆盖范围 -> 全局最大覆盖范围
            要是能覆盖到最后一个元素的下标则能到达该下标
            2 3 1 1 4
            -----
              ------- 到达
         */
        // 特判
        if (nums.length == 1)
            return true;

        int maxCover = 0;
        for (int i = 0; i <= maxCover; i++) {
            // 有可能当前位置覆盖范围，不如之前的已有的覆盖范围
            // 需要比较 max(当前覆盖范围，当前位置能扩展到的覆盖范围)
            maxCover = Math.max(maxCover, i + nums[i]);
            // 如果能覆盖到最后一个元素则为 true
            if (maxCover >= nums.length - 1)
                return true;
        }
        return false;
    }
}
