package round2.hot100.sliding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstring_3 {
    /*
     * 滑动窗口
     * - 外层循环维护右边界，内层循环维护左边界
     * - 只要 set 里面包含重复的元素，就不断++左边界
     * - 最后没有重复的时候加入右边界的元素，更新最大长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 特判
        if (s.length() <= 1)
            return s.length();

        Set<Character> set = new HashSet<>();
        int i = 0;
        int maxLen = 0;
        // 外层循环维护右边界
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            // 内层循环维护左边界
            while (set.contains(ch)) {
                // 移除左边界，类似于 ++ 左边界
                set.remove(s.charAt(i));
                ++i;
            }
            // 维护完左边界确保没有重复之后再加入右边界元素
            set.add(ch);
            // 更新长度
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}
