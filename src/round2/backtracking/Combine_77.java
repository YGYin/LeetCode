package round2.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine_77 {
    /*
        组合，无序，不同顺序为同一结果，需要 startIndex 来防止出现重复的组合
        startIndex 记录下一层递归搜索的起始位置
        n 为宽度，k 实际为深度
     */

    // 定义 path 和 res 来记录路径和收获结果
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    private void backtracking(int n, int k, int startIndex) {
        // 组合问题到达叶子节点的时候收获结果
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历本层节点
        // 可剪枝，已选 path.size() 个，还需要 k - path.size() 个
        // 所以集合 n 至多的起始位置为 n - (k - path.size()) + 1
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
