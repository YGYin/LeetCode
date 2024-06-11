package job.top101.binary;

public class BM19_FindPeakElement {
    /*
        寻找峰值
        nums[-1] = nums[n] = −∞
        代表着只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值（爬山）
        二分查找找到峰值，如果 mid > mid + 1，right = mid，否则 left = mid + 1
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 此处不需要等于，否则收敛到 left = right 时会无限循环
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
