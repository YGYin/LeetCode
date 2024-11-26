package round3.hot100.slide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams_438 {
    /*
        找到字符串中所有字母异位词
        1. 分别用两个数组，sCount 和 dict 去遍历字符串 s 和 t
        2. 用滑动窗口处理 sCount，每次删除窗口最左边字符再添加右边字符
            然后用 Arrays.equals 比较两个数组是否相同吗，相同的话下标加入 res
     */
    public List<Integer> findAnagrams(String s, String p) {
        // res 记录相同下标
        List<Integer> res = new ArrayList<>();
        // 特判
        if (s.length() < p.length())
            return res;

        // 定义两个哈希数组
        int[] sCount = new int[27];
        int[] dict = new int[27];

        // 先遍历 p 和 s 中头 p.length 个字符
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            dict[p.charAt(i) - 'a']++;
        }
        // 先比较一次
        if (Arrays.equals(sCount, dict))
            res.add(0);

        // 滑动窗口
        int left = 0;
        // 从 p.length 开始
        for (int right = p.length(); right < s.length(); right++) {
            // 先删除最左边字符并移动左边界，再添加右边字符
            sCount[s.charAt(left) - 'a']--;
            ++left;
            sCount[s.charAt(right) - 'a']++;

            // 每次移动完比较下是否和 dict 相同
            if (Arrays.equals(sCount, dict))
                res.add(left);
        }

        return res;
    }
}
