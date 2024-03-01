package round1.array;

public class SortedSquares_977 {
    // 977. 有序数组的平方
    // 暴力：直接 for 把平方复制到新数组，然后 sort
    // O(n + nlogn)

    // 双指针
    // 因为最大的数一定出现在头尾，用两个指针分别指向头尾
    // 再用一个指针指向新数组尾部，从大到小排列平方数
    // O(n)
    public int[] sortedSquares(int[] nums) {
        int arrLen = nums.length;
        int[] res = new int[arrLen];
        int idx = arrLen - 1;
        int right = arrLen - 1;

        for (int left = 0; left <= right; ) {
            if (nums[left] * nums[left] <= nums[right] * nums[right])
                res[idx] = nums[right] * nums[right--];
            else
                res[idx] = nums[left] * nums[left++];
            --idx;
        }
        return res;
    }
}
