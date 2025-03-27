package round4.leetcode.binary;

public class SearchInsert_35 {
    public int searchInsert(int[] nums, int target) {
        // 对数组长度特判
        if (nums.length == 1)
            return target > nums[0] ? 1 : 0;

        int left = 0, right = nums.length - 1;
        // 左闭右闭，相等时有意义
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
