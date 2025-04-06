package round4.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17 {

    // 字典，和数字下标相映射对应字符串
    String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder builder = new StringBuilder();
    List<String> res = new ArrayList<>();

    /*
        主要思路
        用 digitIndex 指向当前的数字位置，然后进来先映射对应字符串（获得当前层）
        然后 for 中处理当前字符串
     */
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;
        // 传入数字串以及对应的当前数字下标
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int digitIndex) {
        // 如果数字串遍历到结尾了，收获结果
        if (digitIndex == digits.length()) {
            res.add(builder.toString());
            return;
        }

        // 首先将当前下标的数字，映射为对应字符串作为树的当前层
        int curIndex = digits.charAt(digitIndex) - '0';
        String curStr = dict[curIndex];
        for (int i = 0; i < curStr.length(); i++) {
            builder.append(curStr.charAt(i));
            backtracking(digits, digitIndex + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
