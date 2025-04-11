package round4.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {

    StringBuilder builder = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 1)
            return res;

        backtracking(n, n);
        return res;
    }

    // 传入剩余的左右括号个数
    private void backtracking(int left, int right) {
        // 剩余左括号大于有括号不合法，剪枝
        if (left > right)
            return;

        // 左右括号都使用的时候，收获结果
        if (left == 0 && right == 0) {
            res.add(builder.toString());
            return;
        }

        // 处理本层，因为要么选左括号要么右括号，不需要 for
        // 判断两个剩余个数是否为 0，不为 0 进入下一层
        if (left > 0) {
            builder.append('(');
            backtracking(left - 1, right);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right > 0) {
            builder.append(')');
            backtracking(left, right - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
