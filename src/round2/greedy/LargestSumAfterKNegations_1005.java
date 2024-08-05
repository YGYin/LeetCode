package round2.greedy;

import java.util.Arrays;

public class LargestSumAfterKNegations_1005 {
    /*
        K 次取反后最大化的数组和
        贪心：
        1. 优先选择绝对值最大的负数取反，所以要先对原数组按绝对值排序
        2. 要是全是正数后，要是 k 还是奇数的话优先对最小的数取反
            k 是偶数是(包括 0) 就不需要进行取反
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        nums = sortByAbs(nums);

        // 先贪第一次，遍历数组，在 k > 0 时先将所有负数从大到小取反
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                --k;
            }
        }

        // 看 k 是否为奇数，为奇数就对当前最小的正数取反
        // 为偶数则不需要取反
        if (k % 2 == 1)
            nums[nums.length - 1] = -nums[nums.length - 1];

        // 遍历数组，返回数组和
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        return sum;
    }

    // 将数组按绝对值排序
    private int[] sortByAbs(int[] nums) {
        int[] sortedArr = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right]))
                sortedArr[index++] = nums[left++];
            else
                sortedArr[index++] = nums[right--];
        }

        return sortedArr;
    }
}
