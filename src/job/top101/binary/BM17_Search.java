package job.top101.binary;

public class BM17_Search {
    public int search(int[] nums, int target) {
        // 左闭右闭
        int left = 0, right = nums.length - 1;
        int mid;
        // 中间相等时有意义，需要判断
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
