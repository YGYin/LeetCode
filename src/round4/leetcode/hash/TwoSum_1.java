package round4.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    /*
        两数之和
        定义 Map，k: 值  v: 下标
        遍历数组，看是否存在相加等于 target 的数，即 target - nums[i]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
