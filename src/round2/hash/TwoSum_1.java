package round2.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    // 两数之和
    public int[] twoSum(int[] nums, int target) {
        // 用 hashMap 存元素和对应的下标
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 看是否有与当前元素的和为 target 的元素
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            // 储存当前元素的下标
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
