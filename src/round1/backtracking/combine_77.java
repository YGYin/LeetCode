package round1.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combine_77 {
    // 方便移除最后一个节点，path 使用 LinkedList
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 为了方便让 startIndex 直接作为节点值加入到 路径中
        // 此处 startIndex 为 1
        backtracking(n, k, 1);
        return res;
    }

    private void backtracking(int n, int k, int startIndex) {
        // 终止条件，到叶子节点时收获结果
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 处理单层节点逻辑
        // 可剪枝
        // 当 for 起始位置之后的元素个数小于我们需要的元素个数
        // 已经选择元素个数：path.size()
        // 还需要的元素个数: k - path.size()
        // 最多从 n - (k - path.size()) + 1 开始遍历
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            // 将当前节点加入到 path 当中
            path.add(i);
            // 向下递归获取下一层节点
            backtracking(n, k, i + 1);
            // 回溯，将刚加入 path 的节点弹出来
            path.removeLast();
        }
    }
}
