package round4.leetcode.array;

public class Rotate_189 {
    /*
        轮转数组
        1. k 如果超过 nums.length 去要先取模
        2. 先翻转整个数组，再翻转 [0, k-1]，再翻转 [k, nums.length - 1]
     */
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1)
            return;
        k %= nums.length;

        // 先翻转整个数组，再翻转 [0, k-1]，再翻转 [k, nums.length - 1]
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private void swap(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
