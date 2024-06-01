package round1.hot100.binary;

public class SearchInsert_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        // 左闭右闭区间，left = right 有意义
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
                // mid 已经判断过了，无需再框入区间重复判断
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        // 最后位置都收敛到 left
        // 最后要么剩一个元素或者两个元素，要么插头尾，要么插中间
        return left;
    }
}
