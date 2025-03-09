package round4.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring_3 {
    /*
        无重复支付的最长子串
        1. 引入 set 作为滑动窗口
        2. 每次检查是否 contains，包含的话通过内循环更新左边界
        3. 不包含就加入该字符并更新长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        // set 用于作为滑动窗口
        Set<Character> set = new HashSet<>();
        int i = 0;
        int maxLen = 0;
        // 外循环维护右边界
        for (int j = 0; j < s.length(); j++) {
            // 获取当前字符，如果 set 中已经包含该字符则移除，
            // 循环更新左边界，直到没有重复为止
            char ch = s.charAt(j);
            while (set.contains(ch)) {
                set.remove(s.charAt(i));
                i++;
            }
            // 没有重复字符后加入 set 滑动窗口中
            set.add(ch);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
