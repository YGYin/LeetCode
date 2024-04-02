package round1.hot100.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams_438 {
    // 本质上维护一个 p.len 大小的滑动窗口，再用两个数组记录字母出现情况
    // 往前滑的时候，出窗口的 --，进窗口的元素 ++
    // 然后比较两个数组是否相同，相同将下标加入到 list 中
    public List<Integer> findAnagrams(String s, String p) {
        // 找字符串中所有的异位词
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (pLen > sLen)
            return res;
        // 两个数组记录字母出现情况
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        // 先对 s 和 p 遍历一次 pLen
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount))
            res.add(0);
        // 从 pLen 为窗口入口遍历数组 s
        for (int j = pLen; j < sLen; j++) {
            // 加入口减出口
            sCount[s.charAt(j - pLen) - 'a']--;
            sCount[s.charAt(j) - 'a']++;
            if (Arrays.equals(sCount, pCount))
                res.add(j - pLen + 1);
        }

        return res;
    }
}
