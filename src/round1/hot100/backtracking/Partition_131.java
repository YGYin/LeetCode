package round1.hot100.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition_131 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        // 分割回文串
        // 切割问题，需要 startIndex 作为切割线
        backtracking(0, s);
        return res;
    }

    private void backtracking(int startIndex, String s) {
        // 当 startIndex 切到末尾时，也就是在叶节点时收割结果
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历当前层
        for (int i = startIndex; i < s.length(); i++) {
            // 先判断当前节点切割出来的字符串是否为回文串(左闭右闭)
            if (isPalindrome(s, startIndex, i)) {
                // subString 方法左闭右开
                String substr = s.substring(startIndex, i + 1);
                path.add(substr);
            } else // 不是回文串，剪枝跳过
                continue;
            // 是回文串
            // 向下遍历，往后切割剩余待切割的字符串
            backtracking(i + 1, s);
            // 回溯
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end)
            if (s.charAt(start++) != s.charAt(end--))
                return false;

        return true;
    }

}
