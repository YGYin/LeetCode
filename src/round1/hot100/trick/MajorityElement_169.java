package round1.hot100.trick;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {
    /*
        169. 多数元素
        多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
        遍历数组，用 map 记录每个元素的出现频率
        然后遍历 map.entrySet() 看有没有出现频率大于 n/2 的元素
     */
    public int majorityElement(int[] nums) {
        // key: 元素  val: 出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        int target = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() > target)
                return entry.getKey();

        return -1;
    }
}
