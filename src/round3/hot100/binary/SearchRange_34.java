package round3.hot100.binary;

public class SearchRange_34 {
    /*
        在排序数组中查找元素的第一个和最后一个位置
        因为要求复杂度为 O(log n)，需要二分查找
        主要思路：通过两次二分来查找该元素出现的第一个位置和最后一个位置
        1. 关键在于，用 first 和 last 记录出现下标，在相等时分别继续向左收缩或者向右收缩边界，继续搜索
     */
    public int[] searchRange(int[] nums, int target) {
        // 特判
        if (nums.length == 0)
            return new int[]{-1, -1};

        // 定义指针左闭右闭
        int left = 0, right = nums.length - 1;
        // 定义目标区间记录首尾出现的下标
        int first = -1, last = -1;

        int mid;
        // 先向左搜索，相等时收缩右边界
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                // 记录 first 下标，同时收缩右区间
                first = mid;
                right = mid - 1;
            }
            // 其他照常二分
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        // 重置 left 和 right
        left = 0;
        right = nums.length - 1;

        // 向右搜索，相等时收缩左边界
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                // 记录 last 下标，收缩左边界向右搜索
                last = mid;
                left = mid + 1;
            }
            // 其他照常二分
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return new int[]{first, last};
    }
}
