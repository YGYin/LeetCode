package round3.hot100.slide;

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

        Set<Character> set = new HashSet<>();
        int i = 0;
        int maxLen = 0;

        // 外层循环维护右边界
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            // 内层循环维护左侧窗口
            while (set.contains(ch)) {
                // 不断移除左窗口字符
                set.remove(s.charAt(i));
                ++i;
            }
            set.add(ch);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
