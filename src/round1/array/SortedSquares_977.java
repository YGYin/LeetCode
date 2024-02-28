package round1.array;

public class SortedSquares_977 {
    // 977. 有序数组的平方
    // 暴力：直接 for 把平方复制到新数组，然后 sort
    // O(n + nlogn)

    // 双指针
    // 因为最大的数一定出现在头尾，用两个指针分别指向头尾
    // 再用一个指针指向新数组尾部
    // 从大到小排列平方数
    public int[] sortedSquares(int[] nums) {
        int numLen = nums.length;
        int left = 0;
        int right = numLen - 1;
        int index = numLen - 1;
        int[] res = new int[numLen];
        while (left <= right) {
            int lSquare = nums[left] * nums[left];
            int rSquare = nums[right] * nums[right];
            if (lSquare < rSquare) {
                res[index--] = rSquare;
                --right;
            } else {
                res[index--] = lSquare;
                ++left;
            }
        }
        return res;
    }
}
