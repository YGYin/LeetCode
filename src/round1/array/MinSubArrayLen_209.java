package round1.array;

public class MinSubArrayLen_209 {
    // 滑动窗口
    // for 循环的索引 j 为窗口的终止位置
    // 起始位置：当当前窗口的值大于 s，指针向前移动
    // 终止位置：随循环遍历移动
    // O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int subLen = 0;
        int resLen = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                // 当前连续子数组的长度，更新当前最短长度
                subLen = j - i + 1;
                resLen = Math.min(resLen, subLen);
                // 因为当前窗口值 >= s，起始指针向前移动
                // 并减去 nums[i] 数值
                sum -= nums[i++];
            }
        }
        // resLen 有可能未找到满足大小的最短子数组，返回 0
        return resLen == Integer.MAX_VALUE ? 0 : resLen;
    }

}
