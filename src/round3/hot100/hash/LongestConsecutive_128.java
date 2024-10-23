package round3.hot100.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive_128 {
    /*
     * 最长连续序列
     * 1. 遍历一遍，先用 set 去重
     * 2. 遍历 set，如果已经存在 x-1 直接跳过避免重复遍历
     * 如果存在 x+1，则缓存该数往后遍历，并更新最大长度
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        // 新建 set 遍历 nums
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int maxLen = 1;
        // 增强 for 遍历 set
        for (int x : set) {
            if (set.contains(x - 1))
                continue;

            if (set.contains(x + 1)) {
                int temp = x;
                int curLen = 1;
                while (set.contains(temp + 1)) {
                    ++temp;
                    ++curLen;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }
}
