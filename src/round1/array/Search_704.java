package round1.array;

public class Search_704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid;
        // 左闭右开
        // left == right 时为不合法区间
        while (left < right) {
            mid = left + (right - left) / 2;
            // 已经判断过 nums[mid] < target
            // 左为闭区间，无需重复判断 mid
            if (nums[mid] < target)
                left = mid + 1;
                // 但左闭右开区间右边界取不到，所以可以等于 mid
            else if (nums[mid] > target)
                right = mid;
            else
                return mid;
        }
        return -1;
    }
}
