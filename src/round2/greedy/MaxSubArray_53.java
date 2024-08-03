package round2.greedy;

public class MaxSubArray_53 {
    /*
        最大子数组和
        1. 贪心相当于贪每次的和都大于 0，一旦相加小于 0 就重新计数
        2. 需要 maxSum 记录全局最大子数组和，curSum 记录当前子数组和，
        3. 每次先更新 maxSum，一旦 curSum 小于 0 就重新计数
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 先记录 curSum 并更新 maxSum
            curSum += nums[i];
            maxSum = Math.max(curSum, maxSum);
            // 当前和一旦小于 0 就重新计数，相当于重置最大子续和的起始位置
            if (curSum < 0)
                curSum = 0;
        }
        return maxSum;
    }
}
