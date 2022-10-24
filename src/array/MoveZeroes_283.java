package array;

import java.util.ArrayList;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return;

        int left = 0, right = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[left] == 0 && nums[right] == 0)
                ++right;
            else
                swap(nums, left++, right++);

        }
    }

    public void moveZeros_2(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return;

        int left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0)
                swap(nums, left++, right);
            ++right;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp;
        tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
