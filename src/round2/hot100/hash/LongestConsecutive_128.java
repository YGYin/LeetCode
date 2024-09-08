package round2.hot100.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive_128 {
    /*
        最长连续序列
        先遍历一次数组用 hashSet 存元素，set 的元素主要避免大量重复遍历
        比如数组中有 {2, 3, 4, 5, 100, 200}
        开始遍历 set，用 增强 for
        从 2 在 set 中往后查是否存在 x + 1，但如果已经存在 x - 1 的话直接跳过避免重复遍历
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Set<Integer> set = new HashSet<>();
        // 先遍历一次数组全存到 set 中
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int maxLen = 1;
        for (int num : set) {
            // 检查是否包含 x - 1，包含则直接跳过
            if (!set.contains(num - 1)) {
                // 需要缓存该数，遍历 set 过程中不能对原有元素做操作
                int tempNum = num;
                int curLen = 1;
                // 往后遍历查是否存在 x + 1
                while (set.contains(tempNum + 1)) {
                    ++curLen;
                    ++tempNum;
                }
                // 更新最大长度
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }


    /*
        DP: O(n^2)
        1. dp[i]: 以 i 结尾的数字连续的最长序列长度为 dp[i]
        2. 递推公式:
            if(nums[i] == nums[j]+1)
             dp[i] = dp[j] + 1
        3. 初始化: 全部默认为 1
        4. 从左到右，因为不一定会由前面的值推导出当前值，需要记录最大值
     */
    public int longestConsecutive_2(int[] nums) {
        if (nums.length == 0)
            return 0;
        // 数组需要先排序
        Arrays.sort(nums);

        // 初始化 dp 数组
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
