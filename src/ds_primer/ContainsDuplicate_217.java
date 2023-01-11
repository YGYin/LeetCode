package ds_primer;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i] == nums[i + 1])
                return true;
        return false;
    }

    // Hash
    public boolean containsDuplicate_2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x))
                return true;
            set.add(x);
        }
        return false;
    }

}
