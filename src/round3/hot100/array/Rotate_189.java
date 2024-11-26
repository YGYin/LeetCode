package round3.hot100.array;

public class Rotate_189 {
    /*
        轮转数组
        1. k 如果超过 nums.length 去要先取模
        2. 先翻转整个数组，再翻转 [0, k-1]，再翻转 [k, nums.length - 1]
     */
    public void rotate(int[] nums, int k) {
        // 特判
        if (nums.length <= 1)
            return;

        k %= nums.length;

        swapArray(nums, 0, nums.length - 1);
        swapArray(nums, 0, k - 1);
        swapArray(nums, k, nums.length - 1);
    }

    private void swapArray(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
