package round1.hot100.array;

public class Rotate_189 {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1)
            return;
        int len = nums.length;
        int rotateRange = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, rotateRange - 1);
        reverse(nums, rotateRange, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
