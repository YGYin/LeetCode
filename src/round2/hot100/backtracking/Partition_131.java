package round2.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Partition_131 {
    /*
        分割回文串
        用 startIndex 来切割，切到末尾则收获结果
        本层判断是否为回文串，是则加入到 path 中
     */
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        // 切到末尾则收获结果
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 处理本层
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                // 左闭右开
                String substr = s.substring(startIndex, i + 1);
                // 加入到 path 中
                path.add(substr);
                // 切分完当前位置，下一层从 i + 1 开始
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    // 左闭右闭
    private boolean isPalindrome(String s, int left, int right) {
        char[] chars = s.toCharArray();
        while (left < right)
            if (chars[left++] != chars[right--])
                return false;

        return true;
    }
}
