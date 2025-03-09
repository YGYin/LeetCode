package round4.leetcode.array;

public class MaxSubArray_53 {
    /*
        最大子数组和
        类似于尝试去贪每天的正收益，如果相加的和小于就直接重新计算
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 先加，然后更新最大和，如果小于 0 将当前和重置为 0
            curSum += nums[i];
            maxSum = Math.max(curSum, maxSum);
            if (curSum < 0)
                curSum = 0;
        }
        return maxSum;
    }
}
