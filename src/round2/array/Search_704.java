package round2.array;

public class Search_704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 左闭右闭
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
                // 已判断过 mid < target
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
