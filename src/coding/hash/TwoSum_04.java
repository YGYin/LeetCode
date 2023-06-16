package coding.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_04 {
    /*
        1. 为什么会想到用哈希表：
            当我们需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，
            就要第一时间想到哈希法。
            本题需要一个集合来存放我们遍历过的元素，
            然后在遍历数组的时候去询问这个集合，某元素是否遍历过，
            也就是 是否出现在这个集合！
        2. 哈希表为什么用 map
           - 数组的大小是受限制的，而且如果元素很少，而哈希值太大会造成内存空间的浪费。
           - 该题不仅要判断 y 是否存在而且还要记录 y 的下标位置
        3. 本题 map 是用来存什么的
           - k: 数值
           - v: 数值说在下标

        思路：在遍历数组的时候，只需要向map去查询是否有和目前遍历元素匹配的数值
             - 如果有，就找到的匹配对
             - 如果没有，就把目前遍历的元素放进map中，因为map存放的就是我们访问过的元素。

        时间复杂度: O(n)
        空间复杂度: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        // 因为题设 2 <= nums.length 故不用特判
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }

        return new int[2];
    }
}
