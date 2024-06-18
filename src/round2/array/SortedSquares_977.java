package round2.array;

public class SortedSquares_977 {
    /*
        有序数组的平方 双指针
        原来为非递减的整数数组，平方后最大的数一定在两端
        用双指针分别指向左右端，比较平方后数的大小，较大的放入新数组
     */
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        // 定义双指针
        int left = 0;
        int right = len - 1;
        int index = len - 1;
        // 因为 left = right 有意义，该元素也需要放入数组中
        while (left <= right) {
            // 左边元素较大，放入数组后移动左指针
            if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                res[index--] = nums[left] * nums[left];
                ++left;
            } else {
                res[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return res;
    }
}
