package round1.array;

public class Search_704 {
//    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length;
//        int mid;
//        // 左闭右开
//        // left == right 时为不合法区间
//        while (left < right) {
//            mid = left + (right - left) / 2;
//            // 已经判断过 nums[mid] < target
//            // 左为闭区间，无需重复判断 mid
//            if (nums[mid] < target)
//                left = mid + 1;
//                // 但左闭右开区间右边界取不到，所以可以等于 mid
//            else if (nums[mid] > target)
//                right = mid;
//            else
//                return mid;
//        }
//        return -1;
//    }

    // 左闭右开
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid;
        // 左闭右开时，left == right 为不合法区间
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
                // 因为已判断过 mid < target
                // left 的闭区间范围无需再覆盖 mid
            else if (nums[mid] < target)
                left = mid + 1;
                // 因为已判断过 mid > target
                // right 为开区间，right = mid 时本身不会覆盖 mid
            else
                right = mid;
        }
        return -1;
    }

    //左闭右闭
    public int search_1(int[] nums, int target) {
        int left = 0;
        // 左闭右闭区间也要随之变化
        int right = nums.length - 1;
        int mid;
        // 左闭右闭时，left == right 为合法区间
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
                // 因为已判断过 mid < target
                // left 的闭区间范围无需再覆盖 mid
            else if (nums[mid] < target)
                left = mid + 1;
                // 因为已判断过 mid > target
                // right 为开区间，right = mid 时本身不会覆盖 mid
            else
                right = mid - 1;
        }
        return -1;
    }
}
