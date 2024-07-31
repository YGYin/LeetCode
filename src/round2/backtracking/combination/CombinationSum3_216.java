package round2.backtracking.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3_216 {
    /*
        组合总和 III
        找出所有相加之和为 n 的 k 个数的组合
        1. 每个数字最多使用一次
     */
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        // 组合问题，不能重复选取前面元素需要 startIndex
        backtracking(n, k, 1, 0);
        return res;
    }

    private void backtracking(int n, int k, int startIndex, int sum) {
        // 当组合元素个数为 k 且和为 n 时 手机结果
        if (path.size() == k && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 只是个数收集够 k 个但是和不为 n 直接返回
        if (path.size() == k)
            return;

        // 遍历当前层元素
        for (int i = startIndex; i <= 9; i++) {
            // 对当前节点进行操作
            path.add(i);
            backtracking(n, k, i + 1, sum + i);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}
