package offer;

import java.util.Arrays;

public class FindRepeatNumber_03 {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i] == nums[i + 1])
                return nums[i];
        return -1;
    }
}
