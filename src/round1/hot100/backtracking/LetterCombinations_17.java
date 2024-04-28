package round1.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17 {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    // 需要字典来将数字和字母做映射，下表为数字
    String[] digitMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        // digit 有可能为空
        if (digits.isEmpty())
            return res;
        // 组合问题，但此处的 index 用于指向当前选取的数字
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int index) {
        // 树的深度由数字的个数决定，宽度为对应映射的字母长度，
        // 在子节点收获结果
        // index 从 0 开始， 表示遍历到哪一个数字
        // 等于 digits 长度指向末尾才结束搜索
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        // 想要知道当前层的宽度
        // 需要根据 index 当前指向的 digit 获取到映射的字母列表
        char ch = digits.charAt(index);
        String curStr = digitMap[ch - '0'];
        // 遍历当前层
        for (int i = 0; i < curStr.length(); i++) {
            // 选取当前节点，加入到 path 中
            path.append(curStr.charAt(i));
            // 进入到下一层，下一层应该从下一个数字映射的字母中选取
            backtracking(digits, index + 1);
            // 回溯
            path.deleteCharAt(path.length() - 1);
        }
    }
}
