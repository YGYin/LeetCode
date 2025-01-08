package round3.hot100.binary;

public class FindMin_153 {
    /*
        寻找旋转排序数组中的最小值
        1. 通过比较 nums[left] 和 nums[mid] 确定 mid 的左边有序还是右边有序
        2. 分别取有序的区间的最小值，然后搜另外一边
     */
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int minVal = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;

        // 左闭右闭
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 看左边是否有序，有序则取左边的最小值，接着搜索另外一边
            if (nums[left] <= nums[mid]) {
                minVal = Math.min(minVal, nums[left]);
                left = mid + 1;
            }
            // 右边有序，取有序区间最小值，收缩左边
            else {
                minVal = Math.min(minVal, nums[mid]);
                right = mid - 1;
            }
        }

        return minVal;
    }
}
