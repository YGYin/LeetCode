package round2.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17 {

    // 需要字典记录数字和字母组合的对应关系
    String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder builder = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        /*
            主要思路
            用 digitIndex 指向当前的数字位置，然后进来先映射对应字符串（获得当前层）
            然后 for 中处理当前字符串
         */
        if (digits.isEmpty())
            return res;
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int digitIndex) {
        // 当指向数字串末尾时收获结果
        if (digitIndex == digits.length()) {
            res.add(builder.toString());
            return;
        }
        // 映射数字为对应的字符串
        String curStr = dict[digits.charAt(digitIndex) - '0'];
        char[] chars = curStr.toCharArray();
        // 处理本层字符串
        for (int i = 0; i < chars.length; i++) {
            builder.append(chars[i]);
            // 下一层应该移动指向数字的指针，获取到下一个数字对应的字符串
            backtracking(digits, digitIndex + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
