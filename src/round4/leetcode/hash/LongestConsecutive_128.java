package round4.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive_128 {
    /*
        最长连续序列
        1. 遍历一遍，加入 set 先用 set 去重
        2. 遍历 set，如果已经存在 x-1 直接跳过避免重复遍历
            如果存在 x+1，则缓存该数往后遍历，并更新最大长度
     */
    public int longestConsecutive(int[] nums) {
        // 判空
        if (nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        // 遍历数组，加入 set
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int maxLen = 1;
        // 增强 for 遍历 set
        for (int x : set) {
            // 包含 x - 1 跳过，避免重复遍历
            if (set.contains(x - 1))
                continue;

            // 包含 x + 1，则缓存该数往后遍历，并更新最大长度
            if (set.contains(x + 1)) {
                int tempNum = x;
                int curLen = 1;
                while (set.contains(tempNum + 1)) {
                    ++tempNum;
                    ++curLen;
                }
                // 更新最大长度
                maxLen = Math.max(curLen, maxLen);
            }
        }
        return maxLen;
    }
}
