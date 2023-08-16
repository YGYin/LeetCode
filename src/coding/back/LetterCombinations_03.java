package coding.back;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_03 {
    List<String> res = new ArrayList<>();
    StringBuilder tempString = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return res;
        // 初始化字典，以对应键盘上 2-9 的字母映射
        String[] dic = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits, dic, 0);
        return res;
    }

    private void backtracking(String digits, String[] dic, int digitIndex) {
        // 结束条件：当 digits 数字全被遍历完后
        if (digitIndex == digits.length()) {
            res.add(tempString.toString());
            return;
        }
        // 先获取 digits 中当前数字所对应的字符串
        String str = dic[digits.charAt(digitIndex) - '0'];
        // 深度：由 digits 个数决定 遍历宽度：由映射得到的字符串长度决定
        for (int i = 0; i < str.length(); i++) {
            // 处理字符串，将单个字母加入到 temp 中
            tempString.append(str.charAt(i));
            // 回溯
            backtracking(digits, dic, digitIndex + 1);
            // 回溯撤回操作
            tempString.deleteCharAt(tempString.length() - 1);
        }
    }
}
