package round1.hot100.binary;

public class SearchRange_34 {
    /*
        在排序数组中查找元素的第一个和最后一个位置
        做两次二分查找，分开查找第一个和最后一个
        找到目标后再继续往左往右二分，看是否有左右边界
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        // 定义起始下标和结束下标
        int first = -1;
        int last = -1;
        // 左闭右闭
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                // 先找起始下标，起始下标要找最左边
                // 收缩右边界看 mid 的左边还有没有元素等于 target
                first = mid;
                right = mid - 1;
            } else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        // 重置左右区间
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                // 找结尾下标，结尾下标找最右边
                // 收缩左边界，搜索 mid 的右边还有没有元素等于 target
                last = mid;
                left = mid + 1;
            } else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return new int[]{first, last};
    }
}
