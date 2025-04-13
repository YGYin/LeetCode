package round4.leetcode.binary;

public class FindMin_153 {
    /*
            寻找旋转排序数组中的最小值
            1. 通过比较 nums[left] 和 nums[mid] 确定 mid 的左边有序还是右边有序
            2. 如果左边有序，最小值要么为 nums[left]，要么在 mid 的右边
                如果右边有序，最小值要么为 nums[mid]，要么在 mid 的左边
                分别取有序的区间的最小值，然后搜另外一边
         */
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int left = 0, right = nums.length - 1;
        int minVal = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 左边有序，最小值要么为 nums[left]，要么在 mid 的右边
            if (nums[left] <= nums[mid]) {
                minVal = Math.min(minVal, nums[left]);
                left = mid + 1;
            }
            // 如果右边有序，最小值要么为 nums[mid]，要么在 mid 的左边
            else {
                minVal = Math.min(minVal, nums[mid]);
                right = mid - 1;
            }
        }

        return minVal;
    }
}
