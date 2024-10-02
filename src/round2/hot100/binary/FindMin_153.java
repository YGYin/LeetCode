package round2.hot100.binary;

public class FindMin_153 {
    /*
        寻找旋转排序数组中的最小值
        1. 通过比较 nums[left] 和 nums[mid] 确定 mid 的左边有序还是右边有序
        2. 分别取有序的区间的最小值，然后搜另外一边
     */
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int left = 0;
        int right = nums.length - 1;
        int minVal = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // mid 左边有序
            if (nums[left] <= nums[mid]) {
                minVal = Math.min(minVal, nums[left]);
                // 继续搜 mid 右边
                left = mid + 1;
            }
            // mid 的右边有序
            else {
                minVal = Math.min(minVal, nums[mid]);
                // 继续搜 mid 左边
                right = mid - 1;
            }
        }

        return minVal;
    }
}
