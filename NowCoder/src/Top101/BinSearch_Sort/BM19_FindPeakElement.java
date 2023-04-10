package Top101.BinSearch_Sort;

public class BM19_FindPeakElement {
    /*
        前提：对于所有有效的 i 都有 nums[i] != nums[i + 1]
        1. 二分查找首先从数组首尾开始，每次取中间值，直到首尾相遇
        2. 如果中间值的元素大于它右边的元素，说明往右是向下，
           我们不一定会遇到波峰，但是那就往左收缩区间
        3. 如果中间值小于右边的元素，说明往右是向上，向上一定能有波峰，往右收缩区间
        4. 最后区间收尾相遇的点一定就是波峰

        时间复杂度: O(logn)，二分法最坏情况对整个数组连续二分，最多能分 log2 n 次
        时间复杂度: O(1)
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 右边往下，不一定有波峰
            if (nums[mid] > nums[mid + 1])
                right = mid;
                // 右边往上，一定能找到波峰
            else
                left = mid + 1;
        }
        // 其中一个波峰
        return right;
    }
}
