package coding.back.division;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition_06 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        // 如果大于字符串长度说明已经找到一个切割子串
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 左闭右闭
            if (isPalindrome(s, startIndex, i))
                path.add(s.substring(startIndex, i + 1));
            else
                continue;
            // 切割位置后移，保证不重复
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;

        return true;
    }
}
