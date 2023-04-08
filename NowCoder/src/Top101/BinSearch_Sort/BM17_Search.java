package Top101.BinSearch_Sort;

public class BM17_Search {
    /*
        时间复杂度: O(logn)，对长度为 n 的数组进行二分，最坏情况就是取 2 对数
        空间复杂度: O(1)，常数级变量，无额外辅助空间
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 从数组首尾开始，直到两者相遇
        while (left <= right) {
            int mid = (left + right) / 2;
            // 检查中点下标的值
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
