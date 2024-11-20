package round3.hot100.array;

public class MaxSubArray_53 {
    /*
        最大子数组和
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        // 贪心每天的正收益，一旦和小于 0 就重新计数
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            curSum += nums[i];
            maxSum = Math.max(curSum, maxSum);
            if (curSum < 0)
                curSum = 0;
        }
        return maxSum;
    }
}
