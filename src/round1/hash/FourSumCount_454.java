package round1.hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 四个数组中找相加和为 0 的四元组的个数
        // 可以拆分为 a + b 和 c + d  n^4 -> n^2
        // 因为数值大，不仅要存 a + b 的和，还要存该和的出现次数 -> map
        // 然后再遍历 c + d，看 map 中是否存在 target - (a + b)
        // 类似与两数之和的思想
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        // 遍历 a + b，将不同组合的和的出现次数存入 map 中
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int tempSum = nums1[i] + nums2[j];
                // 没有出现过默认为 0 + 1，每次出现都 + 1
                map.put(tempSum, map.getOrDefault(tempSum, 0) + 1);
            }
        }
        // 遍历 c + d
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int tempKey = 0 - (nums3[i] + nums4[j]);
                // 如果找到更新 count 出现次数
                if (map.containsKey(tempKey))
                    count += map.get(tempKey);
            }
        }
        return count;
    }
}
