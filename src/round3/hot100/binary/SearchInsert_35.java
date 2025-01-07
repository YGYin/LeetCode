package round3.hot100.binary;

public class SearchInsert_35 {
    public int searchInsert(int[] nums, int target) {
        // 特判
        if (nums.length == 1)
            return target > nums[0] ? 1 : 0;

        int left = 0;
        int right = nums.length - 1;
        // 左闭右闭，左等于右时有意义
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid])
                right = mid - 1;
            else if (target == nums[mid])
                return mid;
            else
                left = mid + 1;
        }

        return left;
    }
}
