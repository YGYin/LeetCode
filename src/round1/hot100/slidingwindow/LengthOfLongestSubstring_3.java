package round1.hot100.slidingwindow;

import java.util.HashMap;

public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;
        int maxLen = 0;
        int i = 0;
        // key: ch  val: index
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            // 每当有一个字符曾经出现过，就需要判断左界
            // 若被判断的字符上一次出现的位置就在滑动窗口内，即[i，j]内，
            // 则需要 left 改变位置，改变为该字符上次出现位置 +1
            if (map.containsKey(ch))
                i = Math.max(i, map.get(ch) + 1);
            // 放入元素，并更新最大长度
            map.put(ch, j);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
