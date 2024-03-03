package round1.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // 检查是否出现遍历过刚好相加和为 target 的元素 -> 集合
        // key 是不可重复的
        // 因为此处需要返回元素下标，key: element  value: index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 先检查是否存在遍历过与当前元素相加和为 target 的元素
            // target - nums[i]
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            // 目前未出现所需元素，将当前元素加入到 map 中
            map.put(nums[i], i);
        }
        return res;
    }
}
