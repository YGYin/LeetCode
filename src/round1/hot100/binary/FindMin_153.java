package round1.hot100.binary;

public class FindMin_153 {
    public int findMin(int[] nums) {
        /*
            寻找旋转排序数组中的最小值
            对比 寻找旋转排序数组中的目标值，此题找最小值位置
            同样旋转后为两段有序数组
            如果 中间值 < 最右值，则最小值位于左边，收缩右边界
            如果 中间值 > 最右值，则最小值位于右边，收缩左边界
            比较 nums[mid] 和 nums[right] 为了确定最小值位置
         */
        int left = 0;
        int right = nums.length - 1;
        int mid;
        // 当 left = right 时，区间内只剩下一个数必定为最小值可以直接退出循环
        // 若 left <= right 会无法跳出循环，除非手动添加条件
        while (left < right) {
            mid = left + (right - left) / 2;
            // 中值小于右值，中值有可能时最小值
            if (nums[mid] < nums[right])
                right = mid;
                // 中值大于右值，中值不可能时最小值
            else if (nums[mid] > nums[right])
                left = mid + 1;
        }
        return nums[left];
    }
}
