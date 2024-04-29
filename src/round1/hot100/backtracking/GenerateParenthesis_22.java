package round1.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
    List<String> res = new ArrayList<>();
    StringBuilder curStr = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        // 括号生成
        // 1. 本质可以展开为一棵树，为组合问题 -> 回溯
        // 2. 在叶子节点处收获结果
        // 3. 树只有左右两个分叉，且必须满足左剩余括号不能严格大于有剩余括号
        backtracking(n, n);
        return res;
    }

    // 传入当前字符串，还有左右括号剩余个数
    private void backtracking(int left, int right) {
        // 如果左括号剩余个数大于右括号时，不合法，剪枝
        if (left > right)
            return;
        // 在叶子节点处才收获结果
        // 当左右括号都恰好为 0 的时候，收获结果
        if (left == 0 && right == 0) {
            res.add(curStr.toString());
            return;
        }
        // 遍历当前层，因为只有选左括号和选右括号两个分支，无需循环
        if (left > 0) {
            // 选左括号
            curStr.append("(");
            backtracking(left - 1, right);
            // 回溯
            curStr.deleteCharAt(curStr.length() - 1);
        }
        if (right > 0) {
            // 选右括号
            curStr.append(")");
            backtracking(left, right - 1);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
}
