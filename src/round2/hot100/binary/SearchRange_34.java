package round2.hot100.binary;

public class SearchRange_34 {
    /*
        在排序数组中查找元素的第一个和最后一个位置
        因为要求复杂度为 O(log n)，需要二分查找
        主要思路：通过两次二分来查找该元素出现的第一个位置和最后一个位置
        1. 关键在于，用 first 和 last 记录出现下标，在相等时分别继续向左收缩或者向右收缩边界，继续搜索
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        // 定义左右边界和变量记录下标
        int left = 0;
        int right = nums.length - 1;
        // 不存在时返回 -1，初始值就设为 -1
        int first = -1;
        int last = -1;

        // 左闭右闭，第一次二分向左收缩边界搜第一个位置
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                // 记录下标，向左收缩右边界，继续搜索左边数组
                first = mid;
                right = mid - 1;
            } else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        // 重置左右下标，第二次二分向右收缩左边界搜最后一个位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
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
