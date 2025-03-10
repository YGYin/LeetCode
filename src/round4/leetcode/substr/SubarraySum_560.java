package round4.leetcode.substr;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum_560 {
    /*
        和为 K 的子数组
        不能用回溯求组合个数，较麻烦，因为求的为子数组
        - 可以利用类似于两数之和的前缀和思想，两数之和是求是否有两个数的和为 target，nums[i] + nums[j]
            实际求是否存在 target - nums[i]
        - 此处求是子数组的和为 k 的子数组个数，nums[i] + nums[i + 1] + ...
            实际求存在满足多少个 前缀和 preSum - k = targetArray，-> preSum - targetArray = k 的个数
        - 遍历数组求每个 preSum ，看 map 中是否存在 preSum - k，用 hashMap 存当前 preSum 的出现频率，
     */
    public int subarraySum(int[] nums, int k) {
        // 特判
        if (nums.length == 1)
            return nums[0] == k ? 1 : 0;

        // 储存每个前缀和的出现次数，同时需要先存 0，前缀和为 0 的出现次数为 1
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        // 记录满足的目标数组个数
        int count = 0;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            // 如果 map 中存在 preSum - k 说明存在目标数组，因为 k + 目标数组 = preSum
            if (preSumMap.containsKey(preSum - k))
                count += preSumMap.get(preSum - k);
            // 更新 map 当前前缀和的出现次数
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
