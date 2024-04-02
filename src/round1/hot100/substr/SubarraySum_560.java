package round1.hot100.substr;

import java.util.HashMap;
import java.util.HashSet;

public class SubarraySum_560 {
    public int subarraySum(int[] nums, int k) {
        /*
         类似于两数之和的思想
         原来存的是每个元素的值和下标，看 map 中是否存在 target - num[i]
         此处是用 map 存每个前缀和 和 前缀和出现次数，
         看 map 中是否出现过当前前缀和 preSum - k
         若存在这说明有某一区间的和为 k
        */
        if (nums.length == 0)
            return 0;
        // key: 当前前缀和 val: 出现次数 需要预存前缀和为 0 的情况
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int presum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            // 当前前缀和已知，判断是否含有 presum - k 的前缀和，
            // 若存在这说明有某一区间的和为 k
            if (map.containsKey(presum - k))
                count += map.get(presum - k);
            // 更新 map
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }

    // 暴力
    public int subarraySum_2(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    ++count;
            }
            // 每次遍历完一个子串归零
            sum = 0;
        }

        return count;
    }
}
