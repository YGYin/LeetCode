package round2.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSumCount_454 {
    /*
        四数相加
        1. 和两数之和类似，将头两个数组相加，因为求的是满足和为 0 的四元组的个数
            用 map 存，key: 当前 a + b 的和  val: 出现次数
        2. 先遍历 a + b，再遍历 c + d，看 map 是否存在 0 - (c + d)
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int curSum;
            for (int j = 0; j < nums2.length; j++) {
                curSum = nums1[i] + nums2[j];
                map.put(curSum, map.getOrDefault(curSum, 0) + 1);
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int curSum = nums3[i] + nums4[j];
                count += map.getOrDefault(0 - curSum, 0);
            }
        }
        return count;
    }
}
