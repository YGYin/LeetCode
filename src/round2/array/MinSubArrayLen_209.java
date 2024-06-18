package round2.array;

public class MinSubArrayLen_209 {
    /*
        长度最小的子数组 双指针实现滑动窗口
        窗口末尾逐渐扩大，找到满足和 >= target 的长度最小的连续子数组
        1. 窗口结束位置为数组结尾
        2. 窗口起始位置当数组满足 >= target 的时候向前收缩
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums[0] >= target)
            return 1;
        // 窗口起始位置和当前数组和
        int i = 0;
        int sum = 0;
        int minArrLen = Integer.MAX_VALUE;
        // 窗口结束位置
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 当当前和大于 sum 时，先更新长度，然后尝试收缩窗口
            while (sum >= target) {
                minArrLen = Math.min(minArrLen, j - i + 1);
                // 收缩窗口时需要减去对应值
                sum -= nums[i--];
            }
        }
        // 有可能遍历完数组都不满足有子数组和 >= target
        return minArrLen == Integer.MAX_VALUE ? -1 : minArrLen;
    }
}
