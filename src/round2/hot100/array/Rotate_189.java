package round2.hot100.array;

public class Rotate_189 {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1)
            return;
        // 超过数组长度的应该先让 k mod 数组长度
        k %= nums.length;
        // 先反转整个数组，再反转 [0, k - 1]，再反转 [k, nums.length - 1]
        swapArray(nums, 0, nums.length - 1);
        swapArray(nums, 0, k - 1);
        swapArray(nums, k, nums.length - 1);
    }

    void swapArray(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
