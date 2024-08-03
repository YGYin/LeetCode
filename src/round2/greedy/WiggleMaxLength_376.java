package round2.greedy;

public class WiggleMaxLength_376 {
    /*
        摆动序列
        本质就是记录出现波峰或者波谷的次数
        preDiff <= 0 && curDiff > 0 或者 preDiff >= 0 && curDiff < 0 说明出现峰值
        只有出现峰值才更新 preDiff 避免在单调区间有平坡时造成误判
     */
    public int wiggleMaxLength(int[] nums) {
        // 特判
        if (nums.length < 2)
            return nums.length;
        // 默认 preDiff 和 curDiff 都为 0
        int preDiff = 0;
        int curDiff = 0;
        // 记录峰值个数，默认序列最右边有一个峰值
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录当前差值
            curDiff = nums[i + 1] - nums[i];
            // 看是否出现峰值，操作类似于删除前面的相同元素
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                ++count;
                // 只有发生摆动的时候才更新 preDiff
                preDiff = curDiff;
            }
        }
        return count;
    }
}
