package array;

public class RemoveElement_27 {
    // 283 is similar
    public int removeElement(int[] nums, int val) {
        int left = 0, n = nums.length;
        for (int right = 0; right < n; right++)
            if (nums[right] != val)
                nums[left++] = nums[right];

        return left;
    }

}
