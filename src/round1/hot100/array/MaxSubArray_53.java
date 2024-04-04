package round1.hot100.array;

public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        /*
            贪心算法
            1. 明确贪心贪的是子序和为正数，并非每个数都贪正数
               只有当前子数组的和 < 0 时，才抛弃当前子序和重置为 0，从下一位开始
               因为负数对后面的数来说相加只会变小
         */
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            // 先尝试更新当前数组最大和，否则会无法 cover 全是负数的情况
            if (curSum > maxSum)
                maxSum = curSum;
            // 当前子序和 < 0，重置为 0 从下一位开始
            if (curSum < 0)
                curSum = 0;
        }

        return maxSum;
    }
}
