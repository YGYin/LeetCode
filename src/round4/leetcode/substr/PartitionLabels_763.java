package round4.leetcode.substr;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    /*
        划分字符区间
        给你一个字符串 s 。我们要把这个字符串划分为尽可能多(长)的片段，同一字母最多出现在一个片段中
        1. 本质为找每个字母的最大覆盖区间，看是否有有区间覆盖之前出现的字母
        2. 所以需要一个 hashmap 来储存每个字母出现的最大区间的位置
        3. 同时，因为返回的为 每个切割字符串长度，需要 left right 记录左右边界
        4. 遍历数组，当前字符的下标刚好等于其最大区间，则为分割点
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if (s.isEmpty())
            return res;

        // 用哈希数组记录每个字符出现的最大下标
        int[] map = new int[27];
        for (int i = 0; i < s.length(); i++)
            map[s.charAt(i) - 'a'] = i;

        // 使用 双指针 来记录左右边界
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 更新当前字符出现的最大右边界
            char ch = s.charAt(i);
            right = Math.max(right, map[ch - 'a']);

            // 如果已经遍历到当前最大区间，切割子串，更新左指针
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }

        return res;
    }
}
