package coding.hash;

import java.util.HashSet;

public class LengthOfLongestSubstring_09 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        // 定义 hashSet 记录是否有重复字母
        HashSet<Character> set = new HashSet<>();
        // 定义窗口首尾
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            // 看哈希表中是否有储存即将加入滑动窗口的元素
            // 如果存在将哈希表中元素从左边不断移除，直到哈希表中不存在该重复元素
            while (set.contains(s.charAt(end)))
                set.remove(s.charAt(start++));

            set.add(s.charAt(end));
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
