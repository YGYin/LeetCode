package coding.array;

public class search_01 {
    /*
        左闭右闭区间，此时 left == right 有意义
     */
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1])
            return -1;
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    /*
        左闭右开
     */
    public int search_2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }
        return -1;
    }
}
