package coding.array;

public class SortedSquares_03 {
    /*
        因为平方过后最大值一定在两侧，所以可以
        1. 新建数组，定义左右指针指向原数组首尾，index 指针指向新数组末尾
        2. 判断条件为 left <= right，比较左右指针所指向元素大小，
           较大者存入新数组，分别移动较大者指针以及 index 指针
     */
    public int[] sortedSquares(int[] nums) {
        int arrLen = nums.length;
        int left = 0, right = arrLen - 1, index = arrLen - 1;
        int[] res = new int[arrLen];
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right])
                res[index--] = nums[right] * nums[right--];
            else
                res[index--] = nums[left] * nums[left++];
        }
        return res;
    }
}
