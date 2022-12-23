package offer;

import java.util.Arrays;
import java.util.HashSet;

public class FindRepeatNumber_03 {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i] == nums[i + 1])
                return nums[i];
        return -1;
    }

    // Hash, time: O(n) space: O(n)
    public int findRepeatNumber_2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return i;
            set.add(i);
        }
        return -1;
    }
}
