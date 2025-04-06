package round4.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Partition_131 {
    /*
        分割回文串
        用 startIndex 来切割，切到末尾则收获结果
        本层判断 [startIndex, i] 是否为回文串，是则加入到 path 中
     */
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        // 需要 startIndex 作为隔板
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        // 长度等于字符串长度时，说明切割到了末尾，收获结果
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历当前层，判断 [startIndex, i] 是否为回文串，是则加入到 path 中
        for (int i = startIndex; i < s.length(); i++) {
            // 判断回文串，左闭右闭
            if (isPaLindrome(s, startIndex, i)) {
                // 切割出来加入到 path 中
                String substr = s.substring(startIndex, i + 1);
                path.add(substr);
                // 到下一层继续切割
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPaLindrome(String s, int left, int right) {
        char[] chars = s.toCharArray();
        while (left < right)
            if (chars[left++] != chars[right--])
                return false;

        return true;
    }
}
