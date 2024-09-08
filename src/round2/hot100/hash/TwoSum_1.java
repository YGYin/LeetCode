package round2.hot100.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    /*
        两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        // 哈希表 找 target - nums[i]
        // key: 元素  val: 下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
