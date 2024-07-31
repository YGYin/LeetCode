package round2.backtracking.combination;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17 {
    /*
        电话号码的字母组合
        用一个下标指针 index 遍历 digits，类似于 startIndex，
        只不过每次将 index 指针指向的节点用字典 dict 转换为对应的字符串，
        所以 digits 决定回溯树的深度，映射的字符串决定当前层树的宽度
        1. 组合同样要在叶子节点来收集结果，即 index == digit
        2. 涉及到多次拼接字符串，用 builder
     */
    List<String> res = new ArrayList<>();
    // 涉及多次拼接字符串用 string builder
    StringBuilder builder;
    String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;

        builder = new StringBuilder();
        backtracking(digits, 0);

        return res;
    }

    private void backtracking(String digits, int index) {
        // 当 index 等于 digits 的长度的时候收集结果
        if (index == digits.length()) {
            res.add(builder.toString());
            return;
        }
        // 用 index 获取当前的数字，再映射到字典中的字符串
        int curNum = digits.charAt(index) - '0';
        String str = dict[curNum];

        // 处理当前层
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            // 从下一个数字选，index + 1
            backtracking(digits, index + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
