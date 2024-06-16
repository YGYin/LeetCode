package job.top101.binary;

public class BM21_MinNumberInRotateArray {
    /*
        旋转数组的最小数字
        旋转之后的数组实际上可以划分成两个有序的子数组：注意到实际上最小的元素就是两个子数组的分界线
        1. 如果区间中点大于右边界，说明最小数字一定在中点右边
        2. 如果区间中点小于右边界，最小数字一定在中点左边
        3. 如果区间中点等于右边界，逐个缩减右边界

     */
    public int minNumberInRotateArray(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        int left = 0, right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right])
                right = mid;
            else if (nums[mid] > nums[right])
                left = mid + 1;
            else
                --right;
        }
        return nums[left];
    }
}
