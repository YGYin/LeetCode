package coding.hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount_05 {
    /*
        思路:
            1. 定义一个 map，key 放 a 和 b 两数之和，value 放 a 和 b 两数之和出现的次数
            2. 遍历大 A 和大 B 数组，统计两个数组元素之和以及出现的次数，放到 map 中
            3. 定义 count，用来统计 a + b + c + d = 0 出现的次数
            4. 在遍历大 C 和大 D 数组，找到如果 0 - (c + d) 在 map 中出现过的话，
               就用 count += 对应出现次数

        时间复杂度: O(n^2)
        空间复杂度: O(n^2)
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // key - a + b  value - a + b 出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, (map.getOrDefault(sum, 0) + 1));
            }
        int count = 0;

        for (int i = 0; i < nums3.length; i++)
            for (int j = 0; j < nums4.length; j++)
                if (map.containsKey(0 - (nums3[i] + nums4[j])))
                    count += map.get(0 - (nums3[i] + nums4[j]));

        return count;
    }
}
