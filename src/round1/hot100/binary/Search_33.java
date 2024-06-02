package round1.hot100.binary;

public class Search_33 {
    /*
        搜索旋转排序数组
        1 2 3 4 5 6 7 可以大致分为两类
        比较 nums[left] 和 nums[mid] 是为了确定哪半段为有序
        第一类 2 3 4 5 6 7 1，也就是 nums[left] <= nums[mid]
            前半段有序，如果 nums[left] <= target < nums[mid] 就在前半部份找
        第二类 6 7 1 2 3 4 5，也就是 nums[left] > nums[mid]
            后半段有序，如果 nums[mid] < target <= nums[right] 就在后半部份找
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            // 例子: 2 3 4 5 6 7 1
            // 如果前半部份为有序
            // 因此如果 nums[start] <= target < nums[mid] 就在前半部份找
            if (nums[left] <= nums[mid]) {
                // target 在前半部份
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // 例子: 6 7 1 2 3 4 5
            // 前半部分不为有序数组
            else {
                // target 在后半部分
                if (target <= nums[right] && target > nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
