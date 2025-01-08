package round3.hot100.binary;

public class Search_33 {
    /*
        搜索旋转排序数组
        1 2 3 4 5 6 7
        将数组划分为两段有序数组，划分在于比较 nums[left] 和 nums[mid]
        2 3 4 5 6 7 1
        1. 如果 nums[left] <= nums[mid]，前半部份有序，
            如果 nums[left] <= target < nums[mid]，就在前半部分找，否则后半部分找
        6 7 1 2 3 4 5
        2. 如果 nums[left] > nums[mid]，后半部份有序，
            如果 nums[mid] < target <= nums[right]，就在后半部分找，否则前半部份找
     */
    public int search(int[] nums, int target) {
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int left = 0, right = nums.length - 1;

        // 左闭右闭
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            // 先确定哪一遍有序，nums[left] <= nums[mid]，前半部份有序
            if (nums[left] <= nums[mid]) {
                // 看 target 是否为该区间内，是的话收缩右边界，否则收缩左边界
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // 另一边有序，同理看 target 是否位于该区间
            else {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
