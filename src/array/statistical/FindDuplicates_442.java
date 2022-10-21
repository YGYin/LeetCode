package array.statistical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates_442 {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] == nums[i + 1])
                list.add(nums[i]);
        }
        return list;
    }

    public List<Integer> findDuplicates_2(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : nums) {
            if (nums[Math.abs(x) - 1] < 0)
                list.add(Math.abs(x));
            else
                nums[Math.abs(x) - 1] *= -1;
        }

        return list;
    }
}
