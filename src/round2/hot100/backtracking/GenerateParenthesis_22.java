package round2.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
    /*
        括号生成
        n 为括号对数，生成所有可能的并且 有效的 括号组合
     */
    List<String> res = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtracking(n, n);
        return res;
    }

    // 传入左右括号 剩余 个数，方便判断结束条件，都减到 0 的时候满足条件
    void backtracking(int left, int right) {
        // 剪枝，当剩余左括号多于右括号时不合法
        if (left > right)
            return;
        // 结束条件：两个括号剩余个数都减到 0
        if (left == 0 && right == 0) {
            res.add(builder.toString());
            return;
        }

        // 处理本层，因为要么选左括号要么右括号，不需要 for
        // 判断两个剩余个数是否为 0，不为 0 进入下一层
        if (left > 0) {
            builder.append("(");
            backtracking(left - 1, right);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right > 0) {
            builder.append(")");
            backtracking(left, right - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
