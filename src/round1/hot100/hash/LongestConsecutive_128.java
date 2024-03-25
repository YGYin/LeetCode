package round1.hot100.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        // 1. 使用 set 去重
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            numSet.add(nums[i]);
        int maxLen = 0;
        // 2. 遍历 set
        for (int num : numSet) {
            // 2.1 遍历过程可以避免每次从 x + 1 开始遍历
            //      只要 x 在 set 中不存在 x - 1
            //      就不断遍历是否存在 x + 1 并更新序列长度
            if (!numSet.contains(num - 1)) {
                int tempNum = num;
                int curLen = 1;
                while (numSet.contains(tempNum + 1)) {
                    ++curLen;
                    ++tempNum;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
