package round1.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17 {
    // 收获单个结果
    StringBuilder singleRes = new StringBuilder();
    List<String> res = new ArrayList<>();
    // 数字到字符串需要做映射
    String[] digitsMap = {"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;
        // 传入参数，index 非 startIndex，代表遍历到哪一个数值了
        // 之前在一个组合里收集元素可以用 startIndex
        // 此处在两个或多个集合里收集元素
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int index) {
        // 树的深度由输入数字的个数决定，宽度为对应映射的字母长度，
        // 所要结果在叶子节点里
        // index 从 0 开始， 表示遍历到哪一个数字
        // 等于 digits 长度指向末尾才结束搜索
        if (index == digits.length()) {
            res.add(singleRes.toString());
            return;
        }
        // 先根据 index 取出 digits，用 digits 映射 map 获取字符串
        String str = digitsMap[digits.charAt(index) - '0'];
        // 用 for 遍历字符串，单层处理逻辑，因为在两个集合里取元素
        // 不需要 startIndex
        for (int i = 0; i < str.length(); i++) {
            // 将当前字母加入到 sb 中
            singleRes.append(str.charAt(i));
            // 下一层，获取下一个集合中的元素
            backtracking(digits, index + 1);
            // 回溯
            singleRes.deleteCharAt(singleRes.length() - 1);
        }
    }
}
