package round4.leetcode.binary;

public class SearchRange_34 {
    /*
        在排序数组中查找元素的第一个和最后一个位置
        因为要求复杂度为 O(log n)，需要二分查找
        主要思路：通过两次二分来查找该元素出现的第一个位置和最后一个位置
        关键在于，用 first 和 last 记录出现下标，在相等时先向左搜索，收缩右边界继续二分
        然后再重新在相等时向右搜索，收缩左边界二分，即可分别找到出现的最左位置和最右位置
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1)
            return new int[]{-1, -1};

        // 定义双指针用于二分，定义 first last 记录最初和最后的出现位置
        int left = 0, right = nums.length - 1;
        int first = -1, last = -1;
        int mid;
        // 左闭右闭
        // 向左搜索找元素出现的最左位置
        while (left <= right) {
            mid = left + (right - left) / 2;
            // 向左搜索
            if (target == nums[mid]) {
                first = mid;
                right = mid - 1;
            } else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        // 重置双指针，向右搜索元素出现的最右位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            // 向右搜索
            if (target == nums[mid]) {
                last = mid;
                left = mid + 1;
            } else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return new int[]{first, last};
    }
}
