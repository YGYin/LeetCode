package round2.backtracking.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition_131 {
    /*
        分割回文串
        1. 和组合问题相同，不能重复选取(切割)，startIndex 视为切割线，每次选取 [startIndex, i] 字符串
        2. 当 startIndex == s.length() 时说明已经切到末尾找到一个切割方案，加入到 res 中
        3. 处理当前层节点时，加入 path 之前先判断 [startIndex, i] 是否为回文串
     */
    List<String> path = new LinkedList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {

        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        // startIndex == s.length() 时说明已经切到末尾找到一个切割方案，加入到 res 中
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 处理本层节点
        for (int i = startIndex; i < s.length(); i++) {
            // 判断如果 [startIndex, i] 是回文串的话加入到 path 中
            if (isPalindrome(s, startIndex, i)) {
                // 将当前子串加入到 path 中
                String substr = s.substring(startIndex, i + 1);
                path.add(substr);
            } else
                continue;
            backtracking(s, i + 1);
            // 回溯
            path.remove(path.size() - 1);
        }
    }

    // 左闭右闭
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;

        return true;
    }
}
