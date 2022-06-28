import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    // Brute force
    public int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i)
            for (int j = i + 1; j < nums.length; ++j)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
        return new int[0];
    }

    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (numMap.containsKey(target - nums[i]))
                return new int[]{numMap.get(target - nums[i]), i};

            numMap.put(nums[i], i);
        }
        return new int[0];
    }
}
