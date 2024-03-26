package round1.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition_131 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        // 分割回文串，切割问题
        // 在处理组合问题的时候，递归参数需要传入 startIndex，
        // 表示下一轮递归遍历的起始位置，startIndex 就是切割线
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        // 当 startIndex 切到末尾的时候收割结果
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 将判断字串是否回文串逻辑放入到单层中
        for (int i = startIndex; i < s.length(); i++) {
            // 对于单个切割区间的操作（对于单个节点）
            // 判断字串是否回文串，左闭右闭
            if (isPalindrome(s, startIndex, i)) {
                // 获取该子串，加入到 path 中，左闭右开
                String subStr = s.substring(startIndex, i + 1);
                path.add(subStr);
            } else // 不是回文串直接跳过
                continue;
            // 进入下一层，往后切割
            backtracking(s, i + 1);
            // 回溯，path
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
