package round4.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams_438 {
    /*
        无重复字符的最长子串
        1. 两个 hash 数组，一个目标数组，一个当前滑动窗口数组，先遍历一次 p 获得目标数组
        2. 维护滑动窗口加入右边界的字符，
        3. 如果当前窗口长度和 p 字符串长度相同，则比较两个 hash 数组是否相同，相同加入下标，移动左边界
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.isEmpty() || p.isEmpty())
            return new ArrayList<>();

        // int 数组 target 中存储字符串 p 中对应字符（a~z）出现的次数
        int[] target = new int[26];
        for (int i = 0; i < p.length(); i++)
            ++target[p.charAt(i) - 'a'];
        // window 用于维护滑动窗口当前出现的字符数
        int[] window = new int[26];

        // 定义 左边界指针 及 res
        List<Integer> res = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            // 加入 右边界 字符
            ++window[s.charAt(j) - 'a'];
            // 如果当前窗口长度和 p 长度相等，判断 hash 数组是否一致
            if (j - i + 1 == p.length()) {
                // 一致加入左边界下标
                if (Arrays.equals(window, target))
                    res.add(i);
                // 更新左下标
                --window[s.charAt(i) - 'a'];
                ++i;
            }
        }

        return res;
    }
}
