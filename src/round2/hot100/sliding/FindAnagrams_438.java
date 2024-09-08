package round2.hot100.sliding;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams_438 {
    /*
        找到字符串中所有字母异位词
        - 在 s 中维护一个长度为 p.length 的滑动窗口，判断窗口内容是否为字母异位词
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;

        int[] dict = new int[26];
        int[] sCount = new int[26];
        // 分别用两个字典，dict 只用于比较不操作，sCount 为滑动窗口
        for (int i = 0; i < p.length(); i++) {
            ++dict[p.charAt(i) - 'a'];
            ++sCount[s.charAt(i) - 'a'];
        }
        // 先比较一次看是否相同
        if (Arrays.equals(dict, sCount))
            res.add(0);

        int left = 0;
        for (int right = p.length(); right < s.length(); right++) {

            // 开始滑动，删除窗口最左边字符，右边增加字符
            --sCount[s.charAt(left) - 'a'];
            ++left;
            // 添加窗口右边字符
            ++sCount[s.charAt(right) - 'a'];

            // 判断数组是否相同
            // 判断可以不复制 dict 并做--操作看是否为 0，
            // 可以直接使用 Arrays.equal 方法来比较两者是否相同
            if (Arrays.equals(dict, sCount))
                res.add(left);
        }

        return res;
    }

    public List<Integer> findAnagrams_2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        int[] dict = new int[26];
        for (int i = 0; i < p.length(); i++)
            ++dict[p.charAt(i) - 'a'];

        int left = 0;
        for (int right = p.length() - 1; right < s.length(); right++) {
            // 复制 dict，对复制数组--看是否为 0
            if (isAnagrams(dict, s, left, right)) {
                res.add(left);
            }
            ++left;
        }

        return res;
    }

    private boolean isAnagrams(int[] dict, String s, int left, int right) {
        int[] temp = Arrays.copyOf(dict, 26);

        for (int i = left; i <= right; i++)
            --temp[s.charAt(i) - 'a'];
        for (int i = 0; i < dict.length; i++)
            if (temp[i] != 0)
                return false;

        return true;
    }
}
